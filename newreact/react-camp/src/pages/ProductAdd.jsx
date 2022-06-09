import { Form, Formik } from 'formik'
import React from 'react'
import * as Yup from "yup"
import { Button } from 'semantic-ui-react'
import KodlamaIoTextInput from '../utilities/customFormControls/KodlamaIoTextInput'
import axios from 'axios'

export default function ProductAdd() {
    const initialValues = { productName: "", productDetail: "", unitPrice: 10, unitInStock: 100  }

    const schema = Yup.object({
        productName: Yup.string().required("Ürün adı zorunlu"),
        productDetail: Yup.string().required("Ürün adı zorunlu"),
        unitPrice: Yup.number().required("Ürün fiyatı zorunlu"),
        unitInStock: Yup.number().required("Ürün fiyatı zorunlu")
    })

    return (
            <Formik 
            initialValues={initialValues} 
            validationSchema={schema}
            onSubmit = {(values)=>{
                console.log(values)
                axios({
                    method: "post",
                    url: "http://localhost:8080/api/products/add",
                    data: values 
                  })
            }}
            >
                 <Form className='ui form'>
                    <KodlamaIoTextInput name="productName" placeholder="Ürün adı"/>
                    <KodlamaIoTextInput name="productDetail" placeholder="Ürün detayı"/>
                    <KodlamaIoTextInput name="unitPrice" placeholder="Ürün fiyatı"/>
                    <KodlamaIoTextInput name="unitsInStock" placeholder="Ürün stok"/>
                    <Button color="green" type='submit'>Ekle</Button>
                </Form> 
            </Formik>
    )
}

/* ESKİ TİP FORM
 <Form className='ui form'>
                    <KodlamaIoTextInput name="productName" placeholder="Ürün adı"/>
                    <FormField>
                        <Field name="productName" placeholder="Ürün Adı"></Field>
                        <ErrorMessage name="productName" render={error=>
                            <Label pointing basic color="red" content={error}></Label>
                        }></ErrorMessage>
                    </FormField>
                    <FormField>
                        <Field name="unitPrice" placeholder="Ürün Fiyatı"></Field>
                        <ErrorMessage name="unitPrice" render={error=>
                            <Label pointing basic color="red" content={error}></Label>
                        }></ErrorMessage>
                    </FormField>
                    <Button color="green" type='submit'>Ekle</Button>
                </Form> */