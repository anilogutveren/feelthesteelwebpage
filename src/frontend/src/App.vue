<template class="HomePageTemplate">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <br>
        <app-header></app-header>
        <h6 style="float:right"> Welcome {{ usersName }} </h6>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader";

export default {
  components : {
    appHeader : AppHeader
  }
}
</script>

<style>
.HomePageTemplate{
  background-color: black;
}

body{background-color:  #383838;}

h2{color: Red;}

h6{color: #cccccc}

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
