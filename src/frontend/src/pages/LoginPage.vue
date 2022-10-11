<template>
  <div class="container">
    <h2>Login</h2>
    <hr>
    <div class="form-group">
      <form>
        <label for="username" style="color:White;"> Username or Email: </label>
        <input type="text" id="username" name="username" v-model="userData.username" @input="setUsername"><br><br>
        <label for="password" style="color:White;">Password: </label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Submit">
      </form>
    </div>
    <hr>
    <br>
    <p>TEST: {{loggedInUser.loggedUser}}</p>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
  </div>
</template>

<script>
import {mapActions} from "vuex"
import axios from "axios";
export default {
  name: "LoginPage",
  data(){
    return {
      userData : {
        username : 'Anil',
        password : '',
      },
      loggedInUser : {
        loggedUser: '',
      }
    }
  },
  created(){
  axios.get("http://localhost:8085/user/admin")
      .then(response => {
        this.loggedUser = response.data
        console.log(response.data)
      })
      .catch(e => console.log(e))
  },
  methods: {
    setUsername(){
      this.setValue(this.userData.username)
    },
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    },
    ...mapActions({
      setValue: "setValue"
    })
  }
}

</script>

<style scoped>
p{color: #cccccc}
</style>