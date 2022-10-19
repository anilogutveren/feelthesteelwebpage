<template>
  <div class="container">
    <hr>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
    <div class="row  mt-5">
      <div class="col-md-4 offset-4 card card-primary p-3 border"
           :class="{'border-primary' : isUser, 'border-success' : !isUser }">
        <h3
            :class="{'text-primary' : isUser, 'text-success' : !isUser }"
            class="text-center mb-3 mt-3">Authentication</h3>
        <hr>
        <form @submit.prevent="onSubmit">
          <div class="form-group">
            <label>Your Email</label>
            <input v-model="user.email" type="email" class="form-control"
                   placeholder="Enter your email">
          </div>
          <div class="form-group">
            <label>Şifre</label>
            <input v-model="user.password" type="password" class="form-control" placeholder="Password...">
          </div>
          <div class="button-container d-flex  flex-column align-items-center">
            <button type="submit" :class="{'btn-primary' : isUser, 'btn-success' : !isUser }"
                    class="btn btn-block mb-2">
              {{ isUser ? 'Login' : 'Register' }}
            </button>
            <a href="#" @click.prevent="isUser=!isUser" class="text-secondary">
              {{ isUser ? 'I dont have any account' : 'I have an account'}}
            </a>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>

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
  methods: {
    onSubmit() {
      this.$store.dispatch("login", { ...this.user, isUser : this.isUser  })
          .then(response => {
            this.$router.push("/")
          })
    },
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    }
  }
}
</script>
