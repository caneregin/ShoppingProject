import { Form, Formik } from 'formik'
import React from 'react'
import * as Yup from "yup"
import { Button } from 'semantic-ui-react'
import KodlamaIoTextInput from '../utilities/customFormControls/KodlamaIoTextInput'
import axios from 'axios'
import { useHistory } from 'react-router-dom'

export default function Auth() {
  const initialValues = { userName: "", password: "" }
  const schema = Yup.object({
    userName: Yup.string().required("Kullanici adi zorunlu"),
    password: Yup.string().required("sifre zorunlu")
  })
  const history = useHistory()

  return (
    <div>
      <Formik
        initialValues={initialValues}
        validationSchema={schema}
        onSubmit={(values) => {
          console.log(values)
          axios({
            method: "post",
            url: "http://localhost:8080/auth/register",
            data: values
          })
          history.go("/")
        }}
      >
        <Form className='ui form'>
          <KodlamaIoTextInput name="userName" placeholder="kullanici adi" />
          <KodlamaIoTextInput name="password" placeholder="Sifre" />
          <Button color="green" type='submit'>Kayıt Ol</Button>
        </Form>
      </Formik>
    </div>
  )
}