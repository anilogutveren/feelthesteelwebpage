<template>
  <div class="container">
    <h2>Homepage</h2>
    <img alt="Fts logo" src="../assets/fts.jpg">
    <hr>
    <p>{{admin}}</p>
    <br>
<!--    <iframe width="40%" height="120" allow="autoplay" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/108672044&color=%23ff5500&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true"></iframe><div style="font-size: 10px; color: #cccccc;line-break: anywhere;word-break: normal;overflow: hidden;white-space: nowrap;text-overflow: ellipsis; font-family: Interstate,Lucida Grande,Lucida Sans Unicode,Lucida Sans,Garuda,Verdana,Tahoma,sans-serif;font-weight: 100;"><a href="https://soundcloud.com/officialmetallica" title="Metallica" target="_blank" style="color: #cccccc; text-decoration: none;">Metallica</a> · <a href="https://soundcloud.com/officialmetallica/metallica-master-of-puppets" title="Master Of Puppets (From the Motion Picture Metallica Through the Never)" target="_blank" style="color: #cccccc; text-decoration: none;">Master Of Puppets (From the Motion Picture Metallica Through the Never)</a></div>-->
    <h4 msg="Welcome to FeelTheSteel App"></h4>
    <br>
  </div>
</template>

<script>

export default {
  name: "HomePage",
  data(){
    return {
      admin : ""
    }
  }
}
</script>

<style>
.container{
  background-color: black;
}
h3{color:#cccccc}
p{color:#cccccc}
</style>