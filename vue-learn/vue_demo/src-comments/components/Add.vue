<template>
  <div class="col-md-4">
    <form class="form-horizontal">
      <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" placeholder="用户名" v-model="name">
      </div>
      <div class="form-group">
        <label>评论内容</label>
        <textarea class="form-control" rows="6" placeholder="评论内容" v-model="content"></textarea>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="button" class="btn btn-default pull-right" @click="add">提交</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  props:{
    addComment:{
      type: Function,
      required: true
    }
  },
  data(){
    return {
      name: '',
      content: ''
    }
  },
  methods: {
    add(){
      const name = this.name.trim();
      const content = this.content.trim();
      //1.校验传入的姓名和评论内容是否为空
      if(!name||!content){
        alert('姓名或评论内容不能为空！')
        return
      }
      //2.将输入数据封装为一个comment对象
      const comment = {
        name,
        content
      }
      //3.添加到comments中
      this.addComment(comment)
      this.name = ''
      this.content= ''
    }
  }
}
</script>

<style>

</style>
