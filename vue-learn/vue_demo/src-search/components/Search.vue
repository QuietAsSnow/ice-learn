<template>
  <section class="jumbotron">
    <h3 class="jumbotron-heading">Search Github Users</h3>
    <div>
      <input type="text" placeholder="enter the name you search" v-model="searchName"/>
      <button @click="search">Search</button>
    </div>
  </section>

</template>

<script>
import pubsub from 'pubsub-js'

export default {
  data(){
    return {
      searchName: ''
    }
  },

  methods: {
    search(){
      const searchName = this.searchName.trim()
      if(searchName){
        pubsub.publish('search', searchName)
      }else{
        alert('搜索内容不能为空！')
      }
    }
  }
}
</script>

<style>

</style>
