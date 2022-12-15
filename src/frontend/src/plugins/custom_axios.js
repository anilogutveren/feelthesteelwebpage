import axios from "axios"

const instance = axios.create({
    baseURL : process.env.VUE_APP_FTS_BACKEND_URL,
})

instance.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
instance.defaults.headers.common['Access-Control-Allow-Methods'] = '*'
/*instance.defaults.headers.common['Access-Control-Allow-Credentials'] = true*/
/*instance.defaults.headers.get["X-TrackingId"] = "1245"*/
/*instance.defaults.headers.get["Content-Type"] = "text/plain"*/
/*
instance.defaults.headers.common["Authorization"] = "Basic YWRtaW46MTIzNDU="
*/

export default instance;