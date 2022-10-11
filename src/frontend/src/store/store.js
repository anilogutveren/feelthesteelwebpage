import { createStore } from 'vuex'

// Create a new store instance.
export const store = createStore({
    state () {
        return {
            username: "Ogut"
        }
    },
    getters: {
        getUsername(state){
            return state.username
        }
    },
    mutations: {
        setUsername (state, payload) {
            state.username = payload
        }
    },
    actions: {
        setValue({commit}, payload){
            commit("setUsername", payload)
        }
    }
  }
)
