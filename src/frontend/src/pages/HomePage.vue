<template>
  <div class="container">
    <h2>Homepage</h2>
    <img alt="Fts logo" src="../assets/Goodbye_Prophecy.jpeg">
    <hr>
    <p>{{ admin }}</p>
    <br>
    <!--    <iframe width="40%" height="120" allow="autoplay" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/108672044&color=%23ff5500&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true"></iframe><div style="font-size: 10px; color: #cccccc;line-break: anywhere;word-break: normal;overflow: hidden;white-space: nowrap;text-overflow: ellipsis; font-family: Interstate,Lucida Grande,Lucida Sans Unicode,Lucida Sans,Garuda,Verdana,Tahoma,sans-serif;font-weight: 100;"><a href="https://soundcloud.com/officialmetallica" title="Metallica" target="_blank" style="color: #cccccc; text-decoration: none;">Metallica</a> · <a href="https://soundcloud.com/officialmetallica/metallica-master-of-puppets" title="Master Of Puppets (From the Motion Picture Metallica Through the Never)" target="_blank" style="color: #cccccc; text-decoration: none;">Master Of Puppets (From the Motion Picture Metallica Through the Never)</a></div>-->
    <br>
  </div>
  <hr>
  <button class="button-container d-flex  flex-column align-items-center"
          @click="getNews">Fetch News</button>
  <hr>
</template>

<script>

import customAxios from "../plugins/custom_axios"

export default {
  name: "HomePage",
  data() {
    return {
      admin: ""
    }
  },
  methods: {
    getNews() {
      let newsLink = "http://localhost:8085/news/latest"
      customAxios.get(newsLink).then(response => {
            let responseData = response.data;
            console.log(responseData)
          }
      ).catch(function (error) {
        if (error.response) {
          // The request was made and the server responded with a status code
          // that falls out of the range of 2xx
          console.log("RESPONSE ERROR:" +  error.response.data);
          console.log("RESPONSE ERROR:" + error.response.status);
          console.log("RESPONSE ERROR:" + error.response.headers);
        } else if (error.request) {
          // The request was made but no response was received
          // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
          // http.ClientRequest in node.js
          console.log("REQUEST ERROR:" + error.request);
        } else {
          // Something happened in setting up the request that triggered an Error
          console.log('Error', error.message);
        }
        console.log(error.config);
      });
    }
  }
}
</script>

<style>
body {background-color: black;}

.container {
  background-color: black;
}

h3 {
  color: #cccccc
}

p {
  color: #cccccc
}
</style>