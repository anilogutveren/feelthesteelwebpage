<template>
  <div class="container">
    <h2>Gallery</h2>
    <hr>
    <button class="btn btn-dark" @click="navigateToHome">Back to HomePage</button>
    <hr>
  </div>
</template>

<script>

export default {
  name: "Gallery",
  methods:{
    navigateToHome() {
      this.$router.push({name: 'HomePage'});
    }
  }
}
</script>

<style scoped>

</style>