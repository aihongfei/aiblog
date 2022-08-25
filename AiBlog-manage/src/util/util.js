export function debounce(fn, delay) { //防抖
  let t = null;
  return function () {
    if (t !== null) {
      clearTimeout(t);
    }
    t = setTimeout(() => {
      fn.call(this);
    }, delay)
  }
}

export function getCookie() {
  let cookie = document.cookie.split(";");
  return cookie.map((item, i) => {
    return {
      "key": item.split("=")[0] ? item.split("=")[0].trim() : null,
      "value": item.split("=")[1] ? item.split("=")[1].trim() : null
    }
  });
}
