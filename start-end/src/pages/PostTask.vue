<template>
<div class="post">
    <div class="main-container">
        <h3><i class="fas fa-edit"></i>发布任务</h3>
        <hr>
        <div class="main">
        <input type="text" placeholder="准备做点啥~">
        <textarea name="" id="" cols="30" rows="10" placeholder="描述"></textarea>
        </div>    
    </div>
</div>
</template>

<script>
export default {
    name:'PostTask'
}
</script>

<style scoped>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        .post{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .main-container{
            background-color:white;
            box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
            width: 600px;
            height: 500px;
            padding: 30px;
        }
        .main{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .main input,textarea{
            outline: none;
            float: left;
            margin-top: 10px;
            margin-left: 0;
            left: 0;
            width: 80%;
        }
        .main input{
            border: none;
            border-bottom: solid 1px ;
        }
</style>