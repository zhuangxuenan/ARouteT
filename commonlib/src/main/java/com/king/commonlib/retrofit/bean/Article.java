package com.king.commonlib.retrofit.bean;

import java.util.List;

/***
 *项目名称：ARouteT
 *类描述:
 *创建人：Android
 *创建时间：2019/7/22 18:28
 *修改人：Android
 */
public class Article {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"qing的世界","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8711,"link":"https://juejin.im/post/5d3374cee51d4556bb4cd469","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563705095000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Android多线程技术选型最全指南(part 2 - 认识解决方案)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>据说最新有的方案在P上有兼容性问题。<\/p>","envelopePic":"","fresh":true,"id":8709,"link":"https://www.wanandroid.com/wenda/show/8709","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563698885000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 Android 常见的制作圆角方案，有哪几种常见方式？ 在Android P上什么兼容性问题","type":0,"userId":2,"visible":1,"zan":11},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>最常见的就是 Application 需要设置 NEW_TASK了，为什么需要呢？<\/p><br><p>其他的 Context 呢？<\/p><br><p>能够提取出什么共性吗？<\/p><br><p>本周2/3<\/p>","envelopePic":"","fresh":false,"id":8697,"link":"https://www.wanandroid.com/wenda/show/8697","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563463495000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 哪些 Context调用 startActivity 需要设置NEW_TASK，为什么？","type":0,"userId":2,"visible":1,"zan":10},{"apkLink":"","author":" 七彩祥云至尊宝","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8708,"link":"https://juejin.im/post/5d2c97bff265da1bc552954b","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563461193000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"图解 Java 线程安全","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"DevYK","chapterId":477,"chapterName":"UML","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8706,"link":"https://juejin.im/post/5d2e048cf265da1b9163c7c8","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563460355000,"superChapterId":390,"superChapterName":"项目管理","tags":[],"title":"移动架构 (一) 架构第一步，学会画各种 UML 图。","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 却把清梅嗅","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8705,"link":"https://juejin.im/post/5d2dee0851882569755f5494","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563459884000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"JakeWharton评价我的代码像是在打地鼠？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiangzhihong","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8704,"link":"https://juejin.im/post/5d2eea56f265da1b7004df0d","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563459831000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"史上最全的Android面试题集锦","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Ruheng","chapterId":476,"chapterName":"LRUCache","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8703,"link":"https://www.jianshu.com/p/b49a111147ee","niceDate":"2019-07-17","origin":"","prefix":"","projectLink":"","publishTime":1563335161000,"superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"彻底解析Android缓存机制\u2014\u2014LruCache","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8702,"link":"https://www.jianshu.com/p/68e720b8a939","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292596000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - WorkManger","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8701,"link":"https://www.jianshu.com/p/0b7c82a5c27f","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292583000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - Paging","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8700,"link":"https://www.jianshu.com/p/815c7db24b6d","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292569000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - Room","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" mandypig","chapterId":475,"chapterName":"cookie","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8699,"link":"https://www.jianshu.com/p/bcef63d7e162","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292438000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"熟悉的陌生人cookie，这些你了解吗","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mandypig","chapterId":121,"chapterName":"ViewPager","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8698,"link":"https://www.jianshu.com/p/a7f9f5cdf6f3","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292407000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"ViewPager anr，页面空白问题完全解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>除了明显的disable一些可选性task，还有什么思路吗？  <\/p><br><p>本周/3<\/p>","envelopePic":"","fresh":false,"id":8694,"link":"https://wanandroid.com/wenda/show/8694","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292203000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 如果项目要开始做编译速度优化，你会考虑从哪些地方入手？","type":0,"userId":2,"visible":1,"zan":2},{"apkLink":"","author":"老邢Thierry","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8696,"link":"https://www.jianshu.com/p/0624a18cf8fa","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563207294000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"知乎 Android Gradle plugin 实践","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8695,"link":"https://www.jianshu.com/p/f32c8939338d","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563207249000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"学习Android Jetpack? 实战和教程这里全都有！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>今天问一个老生常谈的问题，很期待大家的回答。<\/p>","envelopePic":"","fresh":false,"id":8685,"link":"https://www.wanandroid.com/wenda/show/8685","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109746000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 Looper.loop为什么不会阻塞掉UI线程？","type":0,"userId":2,"visible":1,"zan":14},{"apkLink":"","author":"lijiankun24","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8693,"link":"https://www.jianshu.com/p/083f8f6ef0c9","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109420000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 性能优化系列 - 03 使用对象池优化内存","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" JasonWuuu","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8692,"link":"https://juejin.im/post/5d29d4def265da1b7638d047","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109396000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android复习资料\u2014\u2014常见面试算法题汇总（一）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 魔都美少年","chapterId":98,"chapterName":"WebView","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8691,"link":"https://juejin.im/post/5d2605f8f265da1bc23fa07c","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109352000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"安卓Webview网页秒开策略探索","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":337,"size":20,"total":6731}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"qing的世界","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8711,"link":"https://juejin.im/post/5d3374cee51d4556bb4cd469","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563705095000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Android多线程技术选型最全指南(part 2 - 认识解决方案)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>据说最新有的方案在P上有兼容性问题。<\/p>","envelopePic":"","fresh":true,"id":8709,"link":"https://www.wanandroid.com/wenda/show/8709","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563698885000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 Android 常见的制作圆角方案，有哪几种常见方式？ 在Android P上什么兼容性问题","type":0,"userId":2,"visible":1,"zan":11},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>最常见的就是 Application 需要设置 NEW_TASK了，为什么需要呢？<\/p><br><p>其他的 Context 呢？<\/p><br><p>能够提取出什么共性吗？<\/p><br><p>本周2/3<\/p>","envelopePic":"","fresh":false,"id":8697,"link":"https://www.wanandroid.com/wenda/show/8697","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563463495000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 哪些 Context调用 startActivity 需要设置NEW_TASK，为什么？","type":0,"userId":2,"visible":1,"zan":10},{"apkLink":"","author":" 七彩祥云至尊宝","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8708,"link":"https://juejin.im/post/5d2c97bff265da1bc552954b","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563461193000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"图解 Java 线程安全","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"DevYK","chapterId":477,"chapterName":"UML","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8706,"link":"https://juejin.im/post/5d2e048cf265da1b9163c7c8","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563460355000,"superChapterId":390,"superChapterName":"项目管理","tags":[],"title":"移动架构 (一) 架构第一步，学会画各种 UML 图。","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 却把清梅嗅","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8705,"link":"https://juejin.im/post/5d2dee0851882569755f5494","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563459884000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"JakeWharton评价我的代码像是在打地鼠？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiangzhihong","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8704,"link":"https://juejin.im/post/5d2eea56f265da1b7004df0d","niceDate":"2019-07-18","origin":"","prefix":"","projectLink":"","publishTime":1563459831000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"史上最全的Android面试题集锦","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Ruheng","chapterId":476,"chapterName":"LRUCache","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8703,"link":"https://www.jianshu.com/p/b49a111147ee","niceDate":"2019-07-17","origin":"","prefix":"","projectLink":"","publishTime":1563335161000,"superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"彻底解析Android缓存机制\u2014\u2014LruCache","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8702,"link":"https://www.jianshu.com/p/68e720b8a939","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292596000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - WorkManger","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8701,"link":"https://www.jianshu.com/p/0b7c82a5c27f","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292583000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - Paging","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8700,"link":"https://www.jianshu.com/p/815c7db24b6d","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292569000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"即学即用Android Jetpack - Room","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" mandypig","chapterId":475,"chapterName":"cookie","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8699,"link":"https://www.jianshu.com/p/bcef63d7e162","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292438000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"熟悉的陌生人cookie，这些你了解吗","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mandypig","chapterId":121,"chapterName":"ViewPager","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8698,"link":"https://www.jianshu.com/p/a7f9f5cdf6f3","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292407000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"ViewPager anr，页面空白问题完全解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>除了明显的disable一些可选性task，还有什么思路吗？  <\/p><br><p>本周/3<\/p>","envelopePic":"","fresh":false,"id":8694,"link":"https://wanandroid.com/wenda/show/8694","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563292203000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 如果项目要开始做编译速度优化，你会考虑从哪些地方入手？","type":0,"userId":2,"visible":1,"zan":2},{"apkLink":"","author":"老邢Thierry","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8696,"link":"https://www.jianshu.com/p/0624a18cf8fa","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563207294000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"知乎 Android Gradle plugin 实践","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"TeaOf","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8695,"link":"https://www.jianshu.com/p/f32c8939338d","niceDate":"2019-07-16","origin":"","prefix":"","projectLink":"","publishTime":1563207249000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"学习Android Jetpack? 实战和教程这里全都有！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>今天问一个老生常谈的问题，很期待大家的回答。<\/p>","envelopePic":"","fresh":false,"id":8685,"link":"https://www.wanandroid.com/wenda/show/8685","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109746000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 Looper.loop为什么不会阻塞掉UI线程？","type":0,"userId":2,"visible":1,"zan":14},{"apkLink":"","author":"lijiankun24","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8693,"link":"https://www.jianshu.com/p/083f8f6ef0c9","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109420000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 性能优化系列 - 03 使用对象池优化内存","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" JasonWuuu","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8692,"link":"https://juejin.im/post/5d29d4def265da1b7638d047","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109396000,"superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android复习资料\u2014\u2014常见面试算法题汇总（一）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 魔都美少年","chapterId":98,"chapterName":"WebView","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8691,"link":"https://juejin.im/post/5d2605f8f265da1bc23fa07c","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563109352000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"安卓Webview网页秒开策略探索","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 337
         * size : 20
         * total : 6731
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : qing的世界
             * chapterId : 67
             * chapterName : 网络基础
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : true
             * id : 8711
             * link : https://juejin.im/post/5d3374cee51d4556bb4cd469
             * niceDate : 1天前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1563705095000
             * superChapterId : 98
             * superChapterName : 网络访问
             * tags : []
             * title : Android多线程技术选型最全指南(part 2 - 认识解决方案)
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
