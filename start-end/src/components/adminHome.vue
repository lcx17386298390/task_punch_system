
<template>
  <div>
    <div class="views">
      <router-link to="/ViewAllTasks" class="view">
        <i class="fas fa-edit"><i>View All Tasks</i></i> 
      </router-link>
      <router-link to="/GiveTask" class="view">
        <i class="fa fa-plus"><i>Give Task</i></i>
      </router-link>
      <router-link to="/SendMsg" class="view">
        <i class="fa fa-plus"><i>Send Msg</i></i>
      </router-link>
    </div>
  </div>
</template>
<script>
// // import Self from '@/components/general/Self'
export default {
  name: "Home",
  components: {
    // GiveTask,
    // ViewAllTasks,
    // ViewStatus,
  },
  data() {
    return {};
  },
};
</script>
<style>
body {
  background-color: #d4ddec63;
}
.views {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}
.view {
  display: flex;
  align-items: center;
  margin: 10px;
  text-decoration: none;
  color: #333;
  position: relative;
  font-size: 18px;
  transition: all 0.3s ease-in-out;
}
.view::after {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: #333;
  visibility: hidden;
  transform: scaleX(0);
  transition: all 0.3s ease-in-out;
}
.view:hover::after {
  visibility: visible;
  transform: scaleX(1);
}
.view i{
  font-size:30px;
}
.view i i{
  margin-right: 5px;
  font-family: Arial, sans-serif; 
  font-size: 35px;
}
.view:hover {
  color: #6a7471b2;
}
</style>
