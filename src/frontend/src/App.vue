<template>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <br>
        <app-header></app-header>
        <transition name="slide" mode="out-in">
          <router-view></router-view>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader";

export default {
  components : {
    appHeader : AppHeader,
  }
}
</script>

<style>
@keyframes slide-in {
  from {
    transform: translateY(20px);
  }
  to {
    transform: translateY(0px);
  }
}

@keyframes slide-out {
  from {
    transform: translateY(0px);
  }
  to {
    transform: translateY(20px);
  }
}
</style>
