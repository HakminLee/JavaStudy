<template>
  <div>
    <!-- 자식의 name을 searchName으로 전달하고 다시 자식의 변경값을 받아옴 -->
    <!-- <InputName : name='serchName' @update:name='changeSearchName'/> 아래 생략 가능-->
    <InputName v-model:name="searchName" />
    <h3>검색어:{{ searchName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      searchName: 'john',
    };
  },
  methods: {
    // v-model로 양방향 바인딩시 생략 가능
    changeSerchName(name) {
      console.log(name);
      this.searchName = name;
    },
  },
};
</script>
