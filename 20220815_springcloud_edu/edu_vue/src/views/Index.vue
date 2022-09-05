<template>
    <div>
        <Header></Header>
        <div style=" width:1200px; margin:0px auto; margin-top:20px;">
            <!--广告轮播图-->
            <el-carousel indicator-position="outside">
                <el-carousel-item v-for="(item , index) in promotionAdData" :key="index">
                    <a :href="item.link">
                        <img :src="item.img" style='width: 100%;height: 100%;object-fit: cover;'/>
                    </a>
                </el-carousel-item>
            </el-carousel>
        </div>

        <!--容器-->
        <div style="width: 1200PX; min-height:500px; margin:0px auto;">

            <!--课程列表-->
            <div style="width: 850PX;display: inline-block;  ">
                <el-tabs v-model="activeName">
                    <el-tab-pane label="选课" name="allLesson">
                        <!-- 课程形式筛选 -->
                        <div class="tag-group" style="text-align: left">
                            <span class="tag-group__title">形式</span>
                            <el-tag style="margin: 5px;cursor:pointer"
                                    v-for="type in courseTypes"
                                    :key="type.id"
                                    :effect="courseType == type ? 'dark':'plain'"
                                    @click="selectCourseType(type)">
                                {{ type.typeName }}
                            </el-tag>
                            {{courseType.typeName}}
                        </div>
                        <!-- 课程方向筛选 -->
                        <div class="tag-group" style="text-align: left;">
                            <span class="tag-group__title">方向</span>
                            <el-tag style="margin: 5px;cursor:pointer"
                                    v-for="orientation in courseOrientations"
                                    :key="orientation.id"
                                    :effect="courseOrientation == orientation ? 'dark':'plain'"
                                    @click="selectCourseOrientation(orientation)">
                                {{ orientation.orientationName }}
                            </el-tag>
                            {{courseOrientation.orientationName}}
                        </div>
                        <!-- 课程方向下级筛选 （类型）-->
                        <div class="tag-group" style="text-align: left;" v-if="this.subCourseOrientations.length > 0">
                            <span class="tag-group__title">类型</span>
                            <el-tag style="margin: 5px;cursor:pointer"
                                    v-for="orientation in subCourseOrientations"
                                    :key="orientation.id"
                                    :effect="subCourseOrientation == orientation ? 'dark':'plain'"
                                    @click="selectSubCourseOrientation(orientation)">
                                {{ orientation.orientationName }}
                            </el-tag>
                            {{subCourseOrientation.orientationName}}
                        </div>

                        <div id="search">
                            <a href="#" @click="selectOrder('sales')">热门</a>
                            <a href="#" @click="selectOrder('createTime')">最新</a>
                            <a href="#" @click="selectOrder('discounts')">
                                价格<i :class="this.orderType == 'asc'? 'el-icon-caret-top':'el-icon-caret-bottom'"></i>
                            </a>
                            <div id="search-input">
                                <el-input
                                        placeholder="请输入内容"
                                        suffix-icon="el-icon-search"
                                        @change="inputSearchText"
                                        v-model="searchText"/>
                            </div>
                        </div>

                        <ul class="course-ul-pc">
                            <!-- 课程信息展示开始 -->
                            <li class="course-li" v-for="(item , index) in courseList" :key="index">
                                <!-- 课程封面图 -->
                                <img
                                        :src="item.courseImgUrl"
                                        class="teacher-portrait hover-pointer"
                                />
                                <!-- 课程文字信息 -->
                                <div class="content-main">
                                    <!-- 课程标题 -->
                                    <div class="content-title hover-pointer">
                                        <div
                                                class="p-title"
                                                style="text-align:left;"
                                                @click="gotoDetail(item)"
                                        >
                                                <span v-html="item.courseName">

                                                </span>
                                        </div>
                                        <!-- 作者和职称 -->
                                        <p class="p-title-buy text-overflow">
                                                <span class="p-author-span">
                                                  {{item.teacher.teacherName}}
                                                </span>
                                                <span class="p-author-line" />
                                                <span class="p-author-span">
                                                  {{item.teacher.position}}
                                                </span>
                                        </p>
                                        <p></p>
                                        <!-- 课程简单描述 -->
                                        <p class="p-describe" style="text-align:left;" >
                                            <span v-html="item.brief">

                                            </span>


                                        </p>
                                    </div>
                                    <!-- 课程前两个章节信息 -->
                                    <ul class="content-course" style="text-align:left;" v-if="item.courseSections.length > 0">
                                        <!-- 章节1 : 免费试看，通常是第一章的前两节课 -->
                                        <li
                                                class="content-course-lesson text-overflow"
                                                style="width:300px"
                                                v-for="(lesson , index) in item.courseSections[0].courseLessons.slice(0,2)" :key="index">
                                            <!-- 免费试看图标 -->
                                            <img
                                                    src="@/assets/course-list/free-course.png"
                                                    class="free-label hover-pointer"
                                            />
                                            <span class="theme-span hover-pointer">
                                                    {{lesson.theme}}
                                            </span>
                                        </li>

                                    </ul>
                                    <!-- 价格信息 -->
                                    <div class="content-price" style="text-align:left;">
                                        <p class="content-price-p">
                                            <span class="content-price-orange-sm">￥</span>
                                            <span class="content-price-orange">{{item.discounts}}</span>
                                            <span class="current-price">
                                            <span class="current-price-unite">￥</span>
                                                {{item.price}}
                                             </span>
                                            <span class="activity-name">成就自己</span>
                                            <span class="content-price-buy">{{item.sales}}人购买</span>
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <!-- 课程信息结束 -->
                        </ul>

                    </el-tab-pane>
                </el-tabs>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="total"
                        :page-size="pageSize"
                        :current-page="current"
                        @current-change="getCourseList">
                </el-pagination>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
     import Header from "./Header/Header"; //顶部登录条
     import Footer from "./Footer/index"; //顶部登录条
    export default {
        name: "Index",
        components: {
            Header,
            Footer,
             //声明组件
        },
        data() {
            return {
                promotionAdData:[],
                promotionAd:{id:"-1",name:"",spaceId:"",keyword:"",htmlContent:"",text:"",link:"",startTime:"",
                    endTime:"",createTime:"",updateTime:"",status:"",priority:"",img:""},
                activeName: "allLesson",
                course:null,
                courseList:[],  // 课程集合
                courseType:"", //当前课程类型
                courseTypes:[], //课程类型集合
                courseOrientations:[], //上级课程方向集合
                subCourseOrientations:[], //下级课程方向集合
                courseOrientation:"", //当前上级课程方向
                subCourseOrientation:"", //下级课程方向
                searchText:"", //搜索内容
                total:0,
                pageSize:5,
                current: 1,
                orderField:"sales", //三种排序方式 销量sales,最新 createTime,价格 price
                orderType:"asc"//两种排序类型 asc，desc
            };
        },

        methods: {
            //点击选择筛选课程类型
            selectCourseType(courseType){
                if(this.courseType == courseType){
                    this.courseType = "";
                }else{
                    this.courseType = courseType;
                }
                this.getCourseList(this.current);
            },
            //点击选择筛选上级课程方向
            selectCourseOrientation(courseOrientation){
                if(this.courseOrientation == courseOrientation){
                    this.courseOrientation = "";
                }else{
                    this.courseOrientation = courseOrientation;
                    console.log( this.courseOrientation.id)
                    this.axios.get("/course-orientation/parent/" + this.courseOrientation.id)
                        .then(res => {
                            console.log(res)
                            this.subCourseOrientations = res.data;
                        });
                }
                this.getCourseList(this.current);
                this.subCourseOrientation = "";
            },
            //点击选择筛选下级课程方向
            selectSubCourseOrientation(courseOrientation){
                if(this.subCourseOrientation == courseOrientation){
                    this.subCourseOrientation = "";
                }else{
                    this.subCourseOrientation = courseOrientation;
                }
                this.getCourseList(this.current);
            },    
            //选择排序方式
            selectOrder(field){
                this.orderField = field;
                if(field == "discounts"){
                    this.orderType = this.orderType == "asc" ? "desc" : "asc";
                }else{
                    this.orderType = "desc";
                }
                this.getCourseList(this.current);
            },
            //输入搜索文字
            inputSearchText(text){
                this.searchText = text;
                this.getCourseList(this.current);
            },

            //获取广告信息
            loadAdList(){
                this.axios.get("http://192.168.75.245:81/ad_load?sid=1")
                    .then(res => {
                        console.log(res.data);
                        this.promotionAdData = res.data
                    })
            },
            //获得所有课程类型(形式)
            getCourseTypes(){
                this.axios.get("/course-types")
                    .then(res => {
                        console.log(res)
                        this.courseTypes = res.data;

                    });
            },
            //获得所有上级课程方向（方向）
            getCourseOrientations(){
                this.axios.get("/course-orientation")
                    .then(res => {
                        this.courseOrientations = res.data;
                    });
            },
            // 获取全部课程信息，改为连接搜索服务
            getCourseList(current){
                this.current = current;
                //通过课程类型和方向，进行分页查询
                let search = {"orientation.parent.orientationName":this.courseOrientation.orientationName,
                    "orientation.orientationName":this.subCourseOrientation.orientationName,
                    "type.typeName":this.courseType.typeName,
                    "courseName":this.searchText,

                };
                let sort = {"field":this.orderField,"type":this.orderType};
                //查询参数 current 当前页面 1开始，size查询长度，search 过滤条件
                let args = {"current":this.current,"size":this.pageSize,"search":JSON.stringify(search),"sort":JSON.stringify(sort)};
                console.log(args)
                this.axios.post("search-course",args)
                    .then((result) => {
                        console.log(result)
                        this.courseList = result.data.data;
                        this.total = result.data.total;
                        this.pageSize = result.data.pageSize;
                        console.log(this.courseList);
                    }).catch( (error)=>{
                    this.$message.error("获取课程信息失败！");
                });

            },
            gotoDetail(item){
                this.$router.push({ name: "Course", params: { course: item } });
            },
        },
        created() {
            this.loadAdList();
            this.getCourseTypes();
            this.getCourseOrientations();
            this.getCourseList(this.current);
        },
    };
</script>

<style lang="less" scoped>
    @import "../assets/less/common.less";

    .qr-wrapper{
        position: absolute;
        width: 140px;
        height: 140px;
        display: block;
        z-index: 10;
        background: #fff;
        border: 1px solid #e3ebe9;
        box-shadow: 0 2px 3px 0 rgba(0,0,0,.08);
        border-radius: 3px;
        box-sizing: border-box;
        left: -30px;
        top: -150px;
    }

    p {
        margin-top: 0;
    }
    li {
        list-style: none;
    }
    .social-item{
        display: inline-block;
        position: relative;
        width: 80px;
        height: 62px;
    }
    .social-item-img {
        width: 32px;
        height: 32px;
    }
    .split-word{
        display: inherit;
        color: #999;
        font-size: 14px;
        margin: 0 10px;
        position: relative;
    }
    .split-word:before {
        content: "";
        display: inline-block;
        position: absolute;
        width: 30px;
        height: 1px;
        background-color: #d8d8d8;
        margin: 10px 0 0 -44px;
    }
    .split-word:after {
        margin: 10px 0 0 13px;
        content: "";
        display: inline-block;
        position: absolute;
        width: 30px;
        height: 1px;
        background-color: #d8d8d8;
    }
    .article-content{
        font-size: 14px;
        margin-bottom: 40px;
    }
    ol, ul {
        margin: 0;
        padding: 0;
        list-style: none;
    }
    .title {
        font-size: 16px;
        color: #333;
        margin-bottom: 20px;
        font-weight: 500;
    }
    flex {
        display: flex;
    }
    .btn(@a, @b) {
        background-color: @a;
        color: @b;
        border: 1px solid @a;
    }
    .course-ads {
        margin-bottom: 20px;
        cursor: pointer;
        width: 100%;
        max-height: 280px;
        overflow: hidden;
        img {
            width: 100%;
            border-radius: 2px;
        }
    }
    .tab-container {
        width: 100%;
        height: 60px;
        background: #ffffff;
        border-bottom: 1px solid #ededed;
    }
    .vux-tab.course-tab {
        box-sizing: border-box;
        height: 60px;
        width: 200px;
        overflow: hidden;
        font-size: 20px;
        .vux-tab-container {
            width: 260px;
        }
        .vux-tab-item {
            cursor: pointer;
            background: none;
            line-height: 60px;
            font-size: 20px;
        }
        .vux-tab-ink-bar {
            bottom: -1px;
            .vux-tab-bar-inner {
                height: 2px;
            }
        }
    }
    .tab-container {
        width: 100%;
        height: 60px;
        background: #ffffff;
        border-bottom: 1px solid #ededed;
    }
    .course-ul {
        padding: 0 20px;
    }
    .hover-pointer {
        cursor: pointer;
    }
    .course-ul-pc .course-li {
        padding: 30px 0 40px 0;
        border-bottom: 1px solid #ededed;
        position: relative;
        &:last-child {
            border-bottom: 0;
        }
    }
    .current-price {
        font-size: 12px;
        color: #999;
        font-weight: 600;
        text-decoration: line-through;
    }
    .current-price-unite {
        font-size: 12px;
        margin-right: -4px;
    }
    .p-author-line {
        content: "";
        display: inline-block;
        width: 1px;
        height: 10px;
        position: absolute;
        background: #999;
        margin-left: 5px;
        top: 3px;
    }
    .teacher-portrait {
        width: 121px;
        height: 159px;
        border-radius: 4px;
        float: left;
    }
    .content-main {
        line-height: 1.4;
        margin-left: 141px;
        position: relative;
        height: 150px;
    }
    .content-main .p-title {
        font-size: 20px;
        color: #333;
        font-family: PingFangSC-Medium, PingFang SC;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        width: 350px;
    }
    .course-ul-pc .content-main .p-title-buy {
        font-size: 12px;
        color: #999;
        display: inline-block;
        margin-top: 6px;
        position: relative;
        float: right;
        top: -28px;
        font-weight: 400;
    }
    p {
        margin-top: 0;
    }
    .course-ul-pc .p-author-line {
        content: "";
        display: inline-block;
        width: 1px;
        height: 10px;
        position: absolute;
        background: #999;
        margin-left: 5px;
        top: 3px;
    }
    .text-overflow {
        word-wrap: normal;
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
    }
    .course-ul-pc .content-main .p-describe {
        font-size: 14px;
        margin-top: 5px;
        color: #333;
        word-wrap: normal;
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
    }
    .course-ul-pc .content-main .p-author-span:not(:first-child) {
        margin-left: 18px;
    }
    .course-ul-pc .content-main .content-course {
        font-size: 14px;
        padding-top: 25px;
        color: #666;
    }

    ol,
    ul {
        margin: 0;
        padding: 0;
        list-style: none;
    }
    * {
        -webkit-tap-highlight-color: transparent;
    }
    .course-ul-pc .content-main .content-course-lesson {
        display: inline-block;
        width: 304px;
        margin: 2px 40px 6px 0;
    }
    .course-ul-pc .content-main .content-course .free-label {
        width: 50px;
        height: 16px;
        margin: 1px 5px 0 0;
    }
    .course-ul-pc .content-main .content-course-lesson:nth-child(2n) {
        margin-right: 0;
    }

    .course-ul-pc .content-main .content-course-lesson {
        display: inline-block;
        width: 304px;
        margin: 2px 40px 6px 0;
    }
    .course-ul-pc .content-main .content-price {
        height: 28px;
        line-height: 28px;
        position: absolute;
        width: 100%;
        bottom: -4px;
    }
    .course-ul-pc .content-main .content-price-p {
        font-size: 0;
    }
    .course-ul-pc .content-main .content-price-orange-sm {
        color: #ff7452;
        font-size: 14px;
    }

    .content-course {
        font-size: 14px;
        padding-top: 25px;
        color: #666;
    }
    .content-course.free-label {
        width: 50px;
        height: 16px;
        margin: 1px 5px 0 0;
    }

    .content-course-lesson {
        display: inline-block;
        width: 304px;
        margin: 2px 40px 6px 0;
    }
    .content-course-lesson:nth-child(2n) {
        margin-right: 0;
    }
    .disabled-word {
        color: #999;
        cursor: default;
    }
    .theme-span :hover {
        color: #0abf89;
    }

    .content-price-p {
        font-size: 0;
    }
    .content-price-orange {
        color: #ff7452;
        font-size: 20px;
    }
    .content-price-buy {
        font-size: 14px;
        color: #999;
        margin-left: 20px;
        transform: translate(8px, -2px);
        display: inline-block;
    }
    .content-price-grey {
        color: #999;
        font-size: 12px;
        margin-left: 5px;
    }
    .content-price-buyed {
        color: #999;
        font-size: 14px;
    }
    .content-price {
        height: 28px;
        line-height: 28px;
        position: absolute;
        width: 100%;
        bottom: -4px;
    }
    .activity-name {
        font-size: 12px;
        line-height: 14px;
        color: rgba(255, 255, 255, 1);
        padding: 2px 4px;
        background: linear-gradient(
                180deg,
                rgba(255, 137, 110, 1) 0%,
                rgba(255, 123, 92, 1) 100%
        );
        border-radius: 2px;
        display: inline-block;
        transform: translate(6px, -3px);
    }
    .p-title {
        font-size: 20px;
        color: #333;
        font-family: PingFangSC-Medium, PingFang SC;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        width: 350px;
    }
    .p-title-dec {
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 1;
        overflow: hidden;
    }
    .p-title-buy {
        // .font(12px);
        font-size: 12px;
        color: #999;
        display: inline-block;
        margin-top: 6px;
        position: relative;
        // .fr;
        top: -28px;
        font-weight: normal;
    }

    .companion-reading {
        background: rgba(0, 179, 138, 0.06);
        border-radius: 2px;
        font-family: PingFangSC-Regular;
        font-size: 12px;
        color: #00b38a;
        display: inline-block;
        padding: 0 8px;
        height: 22px;
        line-height: 22px;
        margin-left: 10px;
        vertical-align: text-bottom;
        position: relative;

        .triangle {
            position: absolute;
            top: 12px;
            left: -3px;
            width: 0;
            height: 0;
            content: "";
            border: 5px solid;
            border-color: transparent transparent white white;
            transform: rotate(45deg);
            box-shadow: -2px 2px 2px rgba(0, 0, 0, 0.08);
        }
    }
    .companion-tip {
        display: none;
        position: absolute;
        font-family: HiraginoSansGB-W3;
        font-size: 14px;
        color: #777777;
        background: #ffffff;
        border: 1px solid #e3ebe9;
        box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.08);
        border-radius: 3px;
        line-height: 29px;
        top: -7px;
        word-break: keep-all;
        left: 80px;
        padding: 0 10px;
        width: 200px;
        z-index: 2;
    }
    .companion-reading:hover .companion-tip {
        display: inline-block;
    }
    .companion-reading:hover .companion-tip {
        display: block;
    }
    .p-describe {
        // .font(14px);
        font-size: 14px;
        margin-top: 5px;
        color: #333;
        // .text-overflow;
    }
    .p-author + p {
        margin-top: 0;
    }
    .p-author {
        margin: 10px 0 5px 0;
        // .font(12px);
        font-size: 12px;
        color: #999;
        position: relative;

        .p-author-line {
            content: "";
            display: inline-block;
            width: 1px;
            height: 10px;
            position: absolute;
            background: #999;
            margin-left: 5px;
            top: 3px;
        }
    }
    .p-author-span:not(:first-child) {
        margin-left: 18px;
    }

    .course-ul-container {
        width: 850px;
        display: inline-block;
        float: left;
    }
    .course-ul {
        padding: 0 20px;
    }
    .course-ul-pc {
        width: 790px;
        background-color: #fff;
        padding: 0 30px;
        // .fl;
    }
    .tag-icon {
        width: 57px;
        height: 18px;
        position: absolute;
        top: 30px;
        left: 0;
    }

    .more-icon {
        width: 10px;
        height: 10px;
        vertical-align: middle;
    }
    .btn {
        width: 94px;
        height: 34px;
        text-align: center;
        line-height: 34px;
        cursor: pointer;
        border-radius: 3px;
        font-size: 14px;
        box-sizing: content-box;
        &-green {
            .btn(#00b38a, #fff);
            &:hover {
                background: #00a57f;
                border-color: #00a57f;
            }
        }
        &-yellow {
            .btn(#fcd766, #fff);
            &:hover {
                background: #f0d071;
                border-color: #f0d071;
            }
        }
        &-white {
            .btn(#fff, #00b38a);
            border: 1px solid #00b38a;
            &:hover {
                color: #fff;
                border-color: #00b38a;
                background-color: #00b38a;
            }
        }
        &-offset {
            position: absolute;
            right: 0;
            top: -4px;
        }
    }

    .btn-center {
        margin: 10px auto;
    }

    .no-data-title {
        font-size: 20px;
        color: #333;
        font-weight: 500;
    }

    #search{
        width: 100%;
        height: 50px;
    }

    #search a{
        color:#0abf89;
        margin-right: 30px;
        line-height: 40px;
        float:left;
    }

    #search-input{
        width: 200px;
        height: 40px;
        float:left;
    }
</style>
