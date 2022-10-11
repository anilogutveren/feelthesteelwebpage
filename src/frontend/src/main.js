import * as Vue from 'vue';
import App from './App.vue'
import router from './routes'
import { store } from "./store/store"
import axios from "axios"

axios.defaults.baseURL = "localhost:8085"
axios.defaults.headers.get["X-TrackingId"] = "1245"
axios.defaults.headers.get["Accepts"] = "application/json"
axios.defaults.headers.common["Authorization"] = "Basic YWRtaW46MTIzNDU="
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'GET'
/*axios.defaults.headers.common["Cookie"] = "JSESSIONID=B62D6CB885FCA45BF8ACDB0BB558AABF"*/

Vue.createApp(App).use(router).use(store).mount('#app');

/*console.log(vm)*/
