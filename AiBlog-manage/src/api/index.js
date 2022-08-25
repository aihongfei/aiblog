import {get, post} from "./http";

export const login = (params) => post('/admin/login',params);

export const logout = (params) => get('/admin/logout',params);

export const getBlogList = (params) => get('/blog/selectAll', params);

export const getBlogById = (params) => get('/blog/selectOne', params);

export const updatePublish = (params) => post('/blog/updatePublish', params);

export const addBlog = (params) => post('/blog/insert', params);

export const updateBlog = (params) => post('/blog/update', params);

export const deleteBlog = (params) => get('/blog/delete', params);

export const getType = (params) => get('/type/selectAll', params);

export const addType = (params) => post('/type/insert', params);

export const deleteType = (params) => get('/type/delete', params);

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

export const addTag = (params) => post('/tag/insert',params);

export const deleteTag = (params) => get('/tag/delete',params);

export const addimg = (params) => post('/blog/img',params);

export const deleteimg = (params) => get('/blog/deleteImg',params);

