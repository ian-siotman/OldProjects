<template>
  <v-container fluid>
    <v-layout row wrap>
      <v-flex xs12 class="text-xs-center" mt-5>
        <h1>Sign up</h1>
      </v-flex>
    </v-layout>
    <v-flex xs12 sm6 offset-sm3 mt-3>
      <!--<form @submit.prevent="userSignUp" :disabled="loading">-->
        <v-layout column>
          <v-alert type="error" dismissible v-model="alert">
            {{ error }}
          </v-alert>
          <v-flex>
            <v-text-field
            name="email"
            label="Email"
            id="email"
            type="email"
            v-model="email"
            required></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
            name="password"
            label="Password"
            id="password"
            type="password"
            v-model="password"
            required></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
            name="confirmPassword"
            label="confirmPassword"
            id="confirmPassword"
            type="password"
            v-model="passwordConfirm"
            :rules="[comparePasswords]"
            required></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="name"
              label="Name"
              id="name"
              v-model="name"
              ></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="phoneNumber"
              label="phoneNumber"
              id="phoneNumber"
              v-model="phoneNumber"
              :rules="[checkPhoneNumber]"
              required
              ></v-text-field>
          </v-flex>
          <v-flex class="text-xs-center" mt-5>
            <v-btn color="primary" @click="insertUser">Sign Up</v-btn>
          </v-flex>
        </v-layout>
      <!--</form>-->
    </v-flex>
  </v-container>
</template>

<script>
/* eslint-disable */
import UserApi from '../../common/js/user-api';
import router from '@/router'

export default {
    data () {
      return {
        email: '',
        name: 'unknown',
        password: '',
        passwordConfirm: '',
        phoneNumber: '',
        alert: false,
      }
    },
    computed: {
      comparePasswords () {
        return this.password === this.passwordConfirm ? true : '비밀번호가 일치하지 않습니다.'
      },
      error () {
        return this.$store.state.error
      },
      loading () {
        return this.$store.state.loading
      },
      checkPhoneNumber () {
        let temp = this.phoneNumber;
        let tokened
        for (let i = 0, iMax = temp.length; i < iMax; i += 1) {
          console.log( Number(temp.charAt(i)) )
          let tokened = Number(temp.charAt(i))
          if(isNaN(tokened)) return '유효하지 않은 값 ' + temp.charAt(i) + '가 포함되었습니다.'
        }
        let returnVal = (this.phoneNumber.length == 12) ? true : '유효하지 않은 휴대전화 번호입니다.'
        return returnVal
      }
    },
    methods: {
      userSignUp () {
        if (this.comparePasswords !== true) {
          return
        }
        this.$store.dispatch('userSignUp', { email: this.email, password: this.password, name: this.name, phoneNumber: this.phoneNumber})
      },
      insertUser() {
        const user = {email: this.email, password: this.password, name: this.name, phoneNumber: this.phoneNumber};
        UserApi.insertUser(user).then((res) => {
          if (res.code >= 400) {
            throw new Error();
          }
          const user = res.data;
          if (user.status === 'USER') user.auth = 0
          else if (user.status === 'SUB_ADMIN') user.auth = 1
          else if (user.status === 'ADMIN') user.auth = 2
          this.$store.commit('setUser', user);
          switch (user.auth) {
            case 0:
              router.push('/home')
              break
            case 1:
            case 2:
              router.push('/admin/home')
              break
            default : throw new Error('알 수 없는 사용자')
          }
        })
      }
    },
    watch: {
      error (value) {
        if (value) {
          this.alert = 'error'
        }
      },
      alert (value) {
        if (!value) {
          this.$store.commit('setError', null)
        }
      }
    }
  }
</script>
