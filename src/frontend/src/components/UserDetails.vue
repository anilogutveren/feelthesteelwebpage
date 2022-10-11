<template>
  <div class="container">
    <h2>UserDetails</h2>
    <hr>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
  </div>
</template>

<script>
export default {
  name: "UserDetails",
  methods:{
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    }
  }
}
</script>

<style scoped>

</style>