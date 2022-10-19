import { createStore } from 'vuex'
import axios from "axios"
import { router } from "../routes"

// Create a new store instance.
export const store = createStore({
    state: {
        token : "",
        fbAPIKey : "",
        user: ""
    },
    getters: {
        isAuthenticated(state){
            return state.token !== ""
        },
        testToken(state){
            return state.token
        },
        getUser(state){
            return state.user
        }
    },
    mutations: {
        setToken(state, token){
            state.token = token
        },
        clearToken(state){
            state.token = ""
        },
        setUser(state, user){
            state.user = user
            console.log(state.user)
        },
        clearUser(state, user){
            state.user = ""
        }
    },
    actions : {
        initAuth({ commit, dispatch }){
            let token = localStorage.getItem("token")
            if(token){
                let expirationDate = localStorage.getItem("expirationDate")
                let time = new Date().getTime()

                if(time >= +expirationDate){
                    console.log("Token expired...")
                    dispatch("logout")
                } else {
                    commit("setToken", token)
                    let timerSecond = +expirationDate - time
                    console.log(timerSecond)
                    dispatch("setTimeoutTimer", timerSecond)
                    router.push("/")
                }

            } else {
                router.push("/login")
                return false
            }
        },
        login({ commit, dispatch, state }, authData){
            let authLink = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key="
            commit("setUser", authData.email)
            return axios.post(
                authLink + "AIzaSyBGXHU4cvqCy4Qtuml2ItuvPsU7OelQ3eo",
                { email :authData.email, password : authData.password, returnSecureToken : true}
            ).then(response => {
                console.log(response.data)
                commit("setToken", response.data.idToken)
                localStorage.setItem("token", response.data.idToken)
                localStorage.setItem("expirationDate", new Date().getTime() + + response.data.expiresIn * 1000)
                dispatch("setTimeoutTimer", +response.data.expiresIn * 1000)
            })
        },
        logout({ commit }){
            commit("clearToken")
            commit("clearUser")
            localStorage.removeItem("token")
            localStorage.removeItem("expirationDate")
            router.push("/login")
        },
        setTimeoutTimer({dispatch}, expiresIn){
            setTimeout(() => {
                dispatch("logout")
            }, expiresIn)
        }
    }
  }
)
