import VueRouter from 'vue-router'

import A from '../pages/A'
import PostTask from '../pages/PostTask'

const router = new VueRouter({
    routes :[
        { 
            path: '/a', 
            component:A
        },
        {
            path: '/postTask',
            component:PostTask
        }
    ]
})

export default router