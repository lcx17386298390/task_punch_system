<template>
  <div class="send_msg">
    <textarea class="text" cols="50" rows="10"></textarea>
    <button class="btn">send</button>
    </div>
</template>

<script>
export default {
  neme:'SendMsg',
  data(){
    return{
        text:''
    }
  },
  
}
</script>

<style>
.send_msg {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}
.text {
    background-color: #d4ddec00;
  border: 1px solid #c7c6c6;
  padding: 5px;
}
.btn {
    margin-block-start: 10px;
}

</style>