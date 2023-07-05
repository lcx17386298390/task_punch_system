import VueRouter from 'vue-router'

import PostTask from '../pages/PostTask'
import GiveTask from '../pages/GiveTask'
import ViewAllTasks from '../pages/ViewAllTasks'

const router = new VueRouter({
    routes :[
        {
            path: '/postTask',
            component:PostTask
        },
        {
            path:'/GiveTask',
            component:GiveTask
        },
        {
            path:'/ViewAllTasks',
            component:ViewAllTasks
        }
    ]
})

export default router