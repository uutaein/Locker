<template>
<v-container>
  <div style="width: 100%;">
    <v-row style="min-height: 300px;">
      <v-col>

        <div class="p-2" style="background-color: #12161A; border-radius: 3px; border: 1px solid #7C4DFF;">

          <div style="font-size: 1.5rem; padding: 3%;">
            <span class="light text-white">내 LOCKER의 레포지토리</span>
          </div>

          <div
            class="list-group kanban-colum p-0 m-0"
            :list="myLockerRepos"
            group="tasks"
            style="text-align: center; background-color: #12161A;"
          >
            <a
              class="list-group-item p-0 m-0"
              v-for="(element, index) in myLockerRepos"
              :key="element.repoUrl"
              style="border-radius: 3px; background-color: #12161A;"
            >
              <img alt="left" id="stat" :src="element.src" @click="getDetail(element)">

              <v-btn
                class="ml-6"
                depressed
                color="#424242"
                text
                icon
                @click="del(index, element.name, element.repoName)"
              >
                <v-icon>mdi-trash-can-outline</v-icon>
              </v-btn>

            </a>
          </div>

        </div>
      </v-col>
    </v-row>
  </div>
</v-container>
</template>
<script>
import { mapState, mapActions } from 'vuex';
import axios from '../../../lib/axios-common';

export default {
  created() {
    this.showRepo;

    // 토큰 값 받아오기
    let token = localStorage.getItem("access_token");
    this.token = token;
    // this.token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTg0MjUzMjAsImV4cCI6MTU5ODQyODkyMH0.fWYAgx6_8qdZW65NmiVsbfOoNHlcCfUAlCLyhSj3bNA"
    let accessToken = localStorage.getItem("github_token");
    this.accessToken = accessToken;
    // this.accessToken = "c259da8189985d4fde5526b9079b9f10f32c519a"
    
    // this.userInfo.uid='jane399'
    // this.userInfo.uid='junhok82'
    // this.userInfo.uid = 'YNNJN'
    // this.userInfo.provider = 'github'
    // this.userInfo.provider = 'google'
    // console.log("userInfo.uid: ", this.userInfo.uid)

    // locker에 저장된 repository 조회하기
    // this.userInfo.id = 17
    // this.userInfo.id = 15
    this.userInfo.id = 21
  },
  computed: {
    showRepo() {
      return this.$store.state.showRepo;
    },
    curRepo(){
      return this.$store.state.curRepo;
    },
    ...mapState(["myLockerRepos","userInfo"])
  },
  data: () => {
    return {
    };
  },
  methods: {
    ...mapActions(["getRepos"]),
    showAction(num) {
      for (var i in this.showRepo) {
        this.showRepo.splice(i, 1, false);
      }
      this.showRepo.splice(num, 1, true);
    },
    del(index, name, repoName){
      // alert("name: "+name+" / repoName: "+repoName)
      var result = confirm(repoName+"을/를 삭제 하시겠어요?");
      if (result) {
        axios
          .delete("/v1/github?name="+name+"&repoName="+repoName)
          .then((res)=> {
            console.log("res", res);
            this.myLockerRepos.splice(index, 1);
            this.getRepos({ token: this.token, accessToken: this.accessToken, uid: this.userInfo.uid, id: this.userInfo.id})
          })
          .catch((err)=> {
            console.log("err", err);
          })
      }
    },
    getDetail(repo){
      this.$store.state.curRepo = repo;
      this.$router.push({name: "repoDetail"})
    }
  }
};
</script>
<style scoped>
</style>
