import { createRouter, createWebHistory } from 'vue-router'; // eslint-disable-line no-unused-vars
import Home from '../views/Home.vue';
import Trade from '../views/Trade.vue';
import Feed from '../views/Feed.vue';
import Notice from '../views/Notice.vue';
import AdList from '../views/AdList.vue';
import Chat from '../views/Chat.vue';
import LoginJoin from '../views/LoginJoin.vue';
import MyPage from '../views/MyPage.vue';
import NoticeAdd from '../views/NoticeAdd.vue';
import ProductAdd from '../views/ProductAdd.vue';
import ProductDetail from '../views/ProductDetail.vue';
import Report from '../views/Report.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/trade',
    name: 'Trade',
    component: Trade,
  },
  {
    path: '/feed',
    name: 'Feed',
    component: Feed,
  },
  {
    path: '/notice',
    name: 'Notice',
    component: Notice,
  },
  {
    path: '/adlist',
    name: 'AdList',
    component: AdList,
  },
  {
    path: '/chat',
    name: 'Chat',
    component: Chat,
  },
  {
    path: '/loginjoin',
    name: 'LoginJoin',
    component: LoginJoin,
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
  },
  {
    path: '/noticeadd',
    name: 'NoticeAdd',
    component: NoticeAdd,
  },
  {
    path: '/productadd',
    name: 'ProductAdd',
    component: ProductAdd,
  },
  {
    path: '/productdetail',
    name: 'ProductDetail',
    component: ProductDetail,
  },
  {
    path: '/report',
    name: 'Report',
    component: Report,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;