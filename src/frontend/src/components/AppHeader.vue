<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow mb-3">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <router-link class="nav-item" to="/">
          <a class="nav-link" href="#">Homepage</a>
        </router-link>
        <router-link class="nav-item" to="/about">
          <a class="nav-link" href="#">About</a>
        </router-link>
        <router-link class="nav-item" to="/gallery">
          <a class="nav-link" href="#">Gallery</a>
        </router-link>
        <router-link class="nav-item" to="/contact">
          <a class="nav-link" href="#">Contact</a>
        </router-link>
        <router-link class="nav-item" to="/login">
          <a class="nav-link" href="#">LoginPage</a>
        </router-link>
      </ul>
      <ul class="navbar-nav my-2 my-lg-0" :class="logoutClass">
        <li class="nav-item">
          <a @click.prevent="logout" class="nav-link" href="#">Log Out</a>
        </li>
      </ul>
    </div>
  </nav>
</template>
<script>
export default {
  methods: {
    logout() {
      this.$store.dispatch("logout")
    }
  },
  computed: {
    logoutClass() {
      return {
        'd-none': !this.$store.getters.isAuthenticated
      }
    }
  }
}
</script>
