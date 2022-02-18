<template>
  <div style="margin: 20vh auto;width: 300px;display: flex;flex-direction: column;">
    <img src="@/asserts/img/img_1.png" style="margin: 15px auto">
    <a-form-model :model="formObj" :label-col="{span: 8}" :wrapper-col="{span: 16}" ref="loginForm">
      <a-form-item label="用户名" prop="username" :required="true"

      >
        <a-input v-model="formObj.username"

        >
          <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)"/>
        </a-input>
      </a-form-item>
      <a-form-item label="密码" prop="password" name="formObj.password" :required="true"
       >
        <a-input v-model="formObj.password" type="password" @keypress.enter="onSubmit"

        >
          <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)"/>
        </a-input>
      </a-form-item>
      <a-form-item class="login-footer" :wrapper-col="{span:24}">
        <a-button @click="resetForm">
          重置
        </a-button>
        <a-button type="primary" html-type="submit" @click="onSubmit"
                  :disabled="formObj.username === '' || formObj.password === ''"
        >
          登录
        </a-button>
      </a-form-item>
    </a-form-model>
  </div>
</template>
<script>

export default {
  name: 'NoodbLogin',
  components: {},
  data: function () {
    return {
      formObj: {
        username: '',
        password: ''
      },
      rules: {
        username: [{
          required: true,
          message: '用户名不能为空',
          trigger: 'change' }],
        password: [{
          required: true,
          message: '密码不能为空',
          trigger: 'change' }]
      }
    }
  },
  methods: {
    onSubmit () {
      const $vm = this
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          $vm.$http({
            url: $vm.$appUrl + this.autoPrefix() + '/user/login',
            method: 'post',
            data: $vm.formObj
          }).then(resp => {
            console.log("dddddsa"+resp)
            console.log(resp)
            if (resp.data.code === 0) {
              // 成功
              $vm.$store.commit('setLoginFlag', true)
              $vm.$store.commit('setUserInfo', resp.data.data)
              this.jumpLastIfRouteHistory($vm)
            }
            else {
              console.log("ddddddddddasdsa")
              $vm.$notification.error({ message: "用户不存在或密码错误" })
            }
          })
        }
      })
    },
    resetForm () {
      this.$refs.loginForm.resetFields()
      this.$data.formObj.username = ''
      this.$data.formObj.password = ''

    },
    jumpLastIfRouteHistory ($vm) {
      if ($vm.$store.state.lastRouteHistory && $vm.$store.state.lastRouteHistory.path) {
        $vm.$router.push($vm.$store.state.lastRouteHistory.path)
      } else {
        $vm.$router.push('/home')
      }
    }

  }
}
</script>
<style scoped lang="css">
.login-footer {
  text-align: center
}

.login-footer button {
  margin: 0 30px;
}

</style>
