<template>
  <div>
    <p>click {{count}} times ,count is{{evenOrOdd}}</p>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>
    <button @click="incrementIfOdd">increment if odd</button>
    <button @click="incrementAsync">increment async</button>
  </div>
</template>

<script>
export default {
  data(){
    return {
      count : 0
    }
  },

  computed: {
    evenOrOdd(){
      return this.count%2 ===1? '奇数':'偶数'
    }
  },

  methods: {
    increment(){
      this.count= this.count +1
    },
    decrement(){
       this.count = this.count -1
    },
    incrementIfOdd(){
      if(this.count%2===1){
        this.count = this.count +1
      }
    },
    incrementAsync(){
      setTimeout(()=>{
        this.count = this.count +1
      },1000)
    }
  }
}
</script>

<style>
</style>
