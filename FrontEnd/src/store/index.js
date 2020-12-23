// //import Vue from 'vue';
// import Vuex from 'vuex';
//
// import {auth} from './auth.module';
//
// //Vue.use(Vuex);
//
// export default Vuex.createStore({
//     state: {},
//     mutations: {},
//     actions: {},
//     modules: { auth }
// });

import { createStore } from "vuex";
import {auth} from './auth.module';

const store = createStore({
    state:{
        name: "Vue"
    },
    modules: {
        auth
    }
});

export default store
