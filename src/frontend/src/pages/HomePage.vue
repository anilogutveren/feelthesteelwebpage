<template>
  <div class="container">
    <h2>Homepage</h2>
    <img alt="Goodbye_Prophecy logo" src="../assets/Goodbye_Prophecy.jpeg">
    <hr>
    <p>{{ admin }}</p>
    <br>
    <!--    <iframe width="40%" height="120" allow="autoplay" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/108672044&color=%23ff5500&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true"></iframe><div style="font-size: 10px; color: #cccccc;line-break: anywhere;word-break: normal;overflow: hidden;white-space: nowrap;text-overflow: ellipsis; font-family: Interstate,Lucida Grande,Lucida Sans Unicode,Lucida Sans,Garuda,Verdana,Tahoma,sans-serif;font-weight: 100;"><a href="https://soundcloud.com/officialmetallica" title="Metallica" target="_blank" style="color: #cccccc; text-decoration: none;">Metallica</a> · <a href="https://soundcloud.com/officialmetallica/metallica-master-of-puppets" title="Master Of Puppets (From the Motion Picture Metallica Through the Never)" target="_blank" style="color: #cccccc; text-decoration: none;">Master Of Puppets (From the Motion Picture Metallica Through the Never)</a></div>-->
    <br>
    <div class="d-flex flex-wrap flex-row justify-content-center align-items-center">
      <div v-for="newsJson in newsList" class="card m-1">
        <ul>
          {{ newsJson.news }}
        </ul>
      </div>
      <div class="card m-1">
        <ul>
          {{ musicians }}
        </ul>
      </div>
    </div>
  </div>

</template>

<script>

import customAxios from "../plugins/custom_axios"

export default {
  name: "HomePage",
  data() {
    return {
      admin: "",
      newsList: [],
      musicians: [],
      backendUrl: process.env.VUE_APP_FTS_BACKEND_URL,
      titleVueApp: process.env.VUE_APP_TITLE
    }
  },
  created() {
    let newsLink = "/news/latest"
    console.log(this.backendUrl)
    console.log(this.titleVueApp)
    customAxios.get(newsLink).then(response => {
          let responseData = response.data;
          console.log(responseData);
          for (let key in responseData) {
            this.newsList.push(responseData[key])
          }
        }
    )
    let musiciansLink = "/musicians"
    customAxios.get(musiciansLink).then(response => {
          let responseData = response.data;
          console.log(responseData);
          this.musicians.push(responseData)
        }
    )
  }
}
</script>

<style>
body {
  background-color: black;
}

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