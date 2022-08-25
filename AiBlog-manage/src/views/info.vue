<template>
  <div class="charts">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <h3 style="margin: 0;">主页展示</h3>
      </div>
      <div class="chart-wrap">
        <el-row>
          <el-col :offset="1" :span="4">
            <el-card class="box-card" >
              <div slot="header" class="clearfix">
                <h4 style="margin: 0;text-align: center;">博客数量</h4>
              </div>
              <div class="animated fadeIn">
                <!-- 图表组件 -->
                <a-chart style="height: 200px" :chartData="blogCoungData"></a-chart>
              </div>
            </el-card>
          </el-col>
          <el-col :offset="0.2" :span="4">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <h4 style="margin: 0;text-align: center;">分类数量</h4>
              </div>
              <div class="animated fadeIn">
                <!-- 图表组件 -->
                <a-chart style="height: 200px" :chartData="typeCountData"></a-chart>
              </div>
            </el-card>
          </el-col>
          <el-col :offset="0.2" :span="4">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <h4 style="margin: 0;text-align: center;">标签数量</h4>
              </div>
              <div class="animated fadeIn">
                <!-- 图表组件 -->
                <a-chart style="height: 200px;" :chartData="tagCountData"></a-chart>
              </div>
            </el-card>
          </el-col>
          <el-col :offset="1" :span="10">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <h4 style="margin: 0;text-align: center;">最新发布</h4>
              </div>
              <el-table :data="blogList" style="width: 100%" :show-header="false" stripe>
                <el-table-column prop="title" label="标题" align="center"></el-table-column>
                <el-table-column prop="createTime" label="日期" align="center"></el-table-column>
              </el-table>
            </el-card>
          </el-col>
        </el-row>
        <br>
        <el-row>
          <el-col :offset="1" :span="10">
            <el-card class="box-card">
              <div class="animated fadeIn">
                <!-- 图表组件 -->
                <a-chart :chartData="typeData"></a-chart>
              </div>
            </el-card>
          </el-col>
          <el-col :offset="1" :span="11">
            <el-card class="box-card">
              <div class="animated fadeIn">
                <!-- 图表组件 -->
                <a-chart :chartData="tagData"></a-chart>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </div>
</template>
<script>

// 引入自己写的通用图表组件
import AChart from "../components/AChart";
import {getBlogList, getTag, getType} from "../api";

export default {
  name: "weather",
  components: {
    "a-chart": AChart
  },
  data() {
    return {
      typeData: {},
      tagData: {},
      blogCoungData: {},
      typeCountData: {},
      tagCountData: {},
      blogList: []
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    getData() {
      getBlogList({pageSize: 4})
        .then(res => {
          this.blogCountChart(res.total);
          this.blogList = res.blogList;
        })
      getType({pageSize: 1000})
        .then(res => {
          this.loading = false;
          let data = res.typeList.map(item => {
            return {
              value: item.count,
              name: item.name
            }
          });
          this.typeChart(data);
          this.typeCountChart(res.count);
        });
      getTag({pageSize: 1000})
        .then(res => {
          let count = res.tagList.map(item => {
            return item.count
          });
          let name = res.tagList.map(item => {
            return item.name
          });
          this.tagChart(name, count);
          this.tagCountChart(res.count);
        })
    },
    // 构建配置对象，渲染折线图
    blogCountChart(data) {
      let opts = {
        series: [
          {
            type: 'gauge',
            axisLine: {
              lineStyle: {
                width: 15,
                color: [
                  [0.3, '#67e0e3'],
                  [0.7, '#37a2da'],
                  [1, '#fd666d']
                ]
              }
            },

            pointer: {
              show: true
            },
            center: ['50%', '30%'],
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            },
            detail: {
              valueAnimation: true,
              formatter: '{value}',
              color: 'auto'
            },
            data: [{value: data}]
          }
        ]
      }
      this.blogCoungData = opts;
    },
    typeCountChart(data) {
      let opts = {
        series: [
          {
            type: 'gauge',
            axisLine: {
              lineStyle: {
                width: 15,
                color: [
                  [0.3, '#67e0e3'],
                  [0.7, '#37a2da'],
                  [1, '#fd666d']
                ]
              }
            },

            pointer: {
              show: true
            },
            center: ['50%', '30%'],
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            },
            detail: {
              valueAnimation: true,
              formatter: '{value}',
              color: 'auto'
            },
            data: [{value: data}]
          }
        ]
      }
      this.typeCountData = opts;
    },
    tagCountChart(data) {
      let opts = {
        series: [
          {
            type: 'gauge',
            axisLine: {
              lineStyle: {
                width: 15,
                color: [
                  [0.3, '#67e0e3'],
                  [0.7, '#37a2da'],
                  [1, '#fd666d']
                ]
              }
            },

            pointer: {
              show: true
            },
            center: ['50%', '30%'],
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            },
            detail: {
              valueAnimation: true,
              formatter: '{value}',
              color: 'auto'
            },
            data: [{value: data}]
          }
        ]
      }
      this.tagCountData = opts;
    },
    typeChart(data) {
      let opts = {
        title: {
          text: '分类',
          subtext: 'type',
          left: 'center'
        },
        color: [
          '#73b9bc',
          '#7289ab',
          '#91ca8c',
          '#f49f42',
          '#dd6b66',
          '#759aa0',
          '#e69d87',
          '#8dc1a9',
          '#ea7e53',
          '#eedd78',
          '#73a373',
        ],
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '分类',
            type: 'pie',
            radius: '50%',
            data: data,
            center: ['50%', '60%'],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }
      this.typeData = opts;
    },
    tagChart(name, count) {
      let opts = {
        title: {
          text: '标签',
          subtext: 'tag',
          left: 'center'
        },
        color: ['#73b9bc'],
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: name,
            axisTick: {
              alignWithLabel: true
            }
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '标签',
            type: 'bar',
            barWidth: '60%',
            data: count
          }
        ]
      }
      this.tagData = opts;
    }
  }
};
</script>
<style scoped lang="scss">
.sel-row {
  margin-bottom: 20px;

  .sel-label {
    line-height: 36px;
  }
}


.box-card {
  margin: auto;
}

.box-card:after {
}

.chart-wrap {
  margin-top: 20px;

}

.el-card__header {
  padding: 0;
}

.ct {
  float: right;
  line-height: 21px;

  &:hover {
    color: #20a0ff;
    cursor: pointer;
  }
}

</style>
