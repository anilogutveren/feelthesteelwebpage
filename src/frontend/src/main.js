import * as Vue from 'vue';
import App from './App.vue'
import router from './routes'
import { store } from "./store/store"

Vue.createApp(App).use(router).use(store).mount('#app');

/*console.log(vm)*/
