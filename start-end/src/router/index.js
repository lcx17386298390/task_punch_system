import VueRouter from 'vue-router'

import A from '../pages/A'

const router = new VueRouter({
    routes :[
        { 
            path: '/a', 
            component:A
        },
    ]
})

export default router