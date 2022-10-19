<template>
  <div class="container">
    <h2>Login Page</h2>
    <hr>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
    <div class="row  mt-5">
      <div class="col-md-4 offset-4 card card-primary p-3 border">
        <h3 class="text-center mb-3 mt-3">Authentication</h3>
        <p v-if="isUser">!!Wrong Credentials!!</p>
        <hr>
        <form @submit.prevent="onSubmit">
          <div class="form-group">
            <label>Your Email</label>
            <input v-model="user.email" type="email" class="form-control"
                   placeholder="Enter your email">
          </div>
          <div class="form-group">
            <label>Password</label>
            <input v-model="user.password" type="password" class="form-control" placeholder="Password...">
          </div>
          <div class="button-container d-flex  flex-column align-items-center">
            <button type="submit">Login</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import {mapGetters, mapActions} from "vuex";
export default {
  data() {
    return {
      user: {
        email: null,
        password: null
      },
      isUser: false
    }
  },
  computed : {
    ...mapGetters({
      isAuthenticated: 'isAuthenticated',
      testToken: 'testToken'
    }),
    ...mapActions([
      "initAuth",
      "login",
      "logout"
    ])
  },
  methods: {
    onSubmit() {
      this.$store.dispatch("login", {...this.user})
          .then(response => {
            if( this.isAuthenticated === true) {
              console.log(this.isAuthenticated)
              console.log(this.$store.getters.testToken)
              this.$router.push("/")
              this.isUser = true
            } else{
                  this.$router.push("/login")
                  this.isUser = false
                  }
          })
    },
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    }
  }
}
</script>

<style scoped>
h3{color: Black;}
</style>