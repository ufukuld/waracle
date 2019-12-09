import React, { Component } from 'react'
import { Formik, Form, Field } from 'formik';
import CakeDataService from '../../api/cake/CakeDataService.js'

class Cake extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            description: ''
        }

        this.onSubmit = this.onSubmit.bind(this)
    }

    componentDidMount() {

        if (this.state.id === -1) {
            return
        }
    }

    onSubmit(values) {
        let cake = {
            id: this.state.id,
            title: values.title,
            description: values.description,
            image: values.image
        }

        CakeDataService.addCake(cake)
                .then(() => this.props.history.push('/cakes'))

        console.log(values);
    }

    render() {

        let { title, description, image } = this.state

        return (
            <div>
                <h1>Cake</h1>
                <div className="container">
                    <Formik
                        initialValues={{ title, description, image }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>Title</label>
                                        <Field className="form-control" type="text" name="title" />
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>

                                    <fieldset className="form-group">
                                        <label>Image</label>
                                        <Field className="form-control" type="text" name="image" />
                                    </fieldset>

                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>
        )
    }
}

export default Cake