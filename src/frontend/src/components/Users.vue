<template>
  <div class="container">
    <h2>Users</h2>
    <h6 style="float:right"> Welcome {{ usersName }} </h6>
    <hr>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
  </div>
</template>

<script>
export default {
  name: "UsersPage",
  methods:{
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    }
  }
}
</script>

<style scoped>

</style>