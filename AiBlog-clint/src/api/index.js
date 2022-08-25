import {get, post} from "./http";

export const getBlogList = (params) => get('/blog/selectAllPublish', params);

export const getBlogListRandom = (params) => get('/blog/selectRandom', params);

export const getBlogListRandomByKey = (params) => get('/blog/selectRandomByKey', params);

export const getType = (params) => get('/type/selectAll', params);

export const getTypeById = (params) => get('/type/selectOne', params);

export const addBlogClickNum = (params) => post('/blog/addClickNum',params);

export const getBlogContent = (params) => get('/blog/selectOne',params);

export const getBlogKeyWord = (params) => get('/blog/search',params);

export const getBlogByTypeId = (params) => get('/blog/selectByTypeId',params);

export const getBlogByTagId = (params) => get('/blog/selectByTagId',params);

export const getComment = (params) => get('/comment/selectByBlogId',params);

export const addComment = (params) => post('/comment/insert',params);

export const getTag = (params) => get('/tag/selectAll',params);

export const getTagByBlogId = (params) => get('/tag/selectByBlogId',params);

const http = {
    getBlogList : (params) => get('/blog/selectAllPublish', params),

    getBlogListRandom : (params) => get('/blog/selectRandom', params),

    getBlogListRandomByKey : (params) => get('/blog/selectRandomByKey', params),

    getType : (params) => get('/type/selectAll', params),

    getTypeById : (params) => get('/type/selectOne', params),

    addBlogClickNum : (params) => post('/blog/addClickNum',params),

    getBlogContent : (params) => get('/blog/selectOne',params),

    getBlogKeyWord : (params) => get('/blog/search',params),

    getBlogByTypeId : (params) => get('/blog/selectByTypeId',params),

    getBlogByTagId : (params) => get('/blog/selectByTagId',params),

    getComment : (params) => get('/comment/selectByBlogId',params),

    addComment : (params) => post('/comment/insert',params),

    getTag : (params) => get('/tag/selectAll',params),

    getTagByBlogId : (params) => get('/tag/selectByBlogId',params),
}

import Vue from "vue";
Vue.prototype.$http = http;
