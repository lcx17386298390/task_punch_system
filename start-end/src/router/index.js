import VueRouter from 'vue-router'
import login from '../components/login'
import adminHome from '../components/adminHome'
import GiveTask from '../pages/GiveTask'
import ViewAllTasks from '../pages/ViewAllTasks'
import SendMsg from '../pages/SendMsg'
import studentHome from '../components/studentHome'
import PostTask from '../pages/PostTask'
import registration from '../components/registration'
import ViewYourTasks from '../pages/ViewYourTasks'
import self from '../components/self.vue'
// import { component } from 'vue/types/umd's

const router = new VueRouter({
    routes: [
        {
            path: 'login', component: login
        },
        {
            path: '/registration', component: registration
        },
        {
            path: '/', component: self
        },
        {
            path: '/adminHome', component: adminHome, children: [
                // { path: '/ViewAllTasks',component: ViewAllTasks},
                // {path: '/GiveTask',component: GiveTask},
                // {path: '/SendMsg',component: SendMsg},
            ]
        },

        { path: '/ViewAllTasks', component: ViewAllTasks },
        { path: '/GiveTask', component: GiveTask },
        { path: '/SendMsg', component: SendMsg },
        { path: '/PostTask', component: PostTask },
        { path: '/ViewYourTasks', component: ViewYourTasks },
        {
            path: '/studentHome', component: studentHome, children: [
                // { path: '/ViewAllTasks',component: ViewAllTasks},
                // {path: '/PostTask',component: PostTask},
            ]
        },

    ]
})

export default router