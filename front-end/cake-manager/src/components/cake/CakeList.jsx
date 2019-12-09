import React, { Component } from 'react'
import CakeDataService from '../../api/cake/CakeDataService.js'

class CakeList extends Component {
    constructor(props) {
        console.log('constructor')
        super(props)
        this.state = {
            cakes: [],
            message: null
        }
        this.addCakeClicked = this.addCakeClicked.bind(this)
        this.refreshCakes = this.refreshCakes.bind(this)
    }

    componentDidMount() {
        this.refreshCakes();
    }

    refreshCakes() {
        CakeDataService.getCakeList()
            .then(
                response => {
                    this.setState({ cakes: response.data })
                }
            )
    }

    addCakeClicked() {
        this.props.history.push(`/cakes/add`)
    }

    render() {
        console.log('render')
        return (
            <div>
                <h1><center>List of Cakes</center></h1>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Description</th>
                                <th>Image</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.cakes.map(
                                    cake =>
                                        <tr key={cake.id}>
                                            <td>{cake.title}</td>
                                            <td>{cake.description}</td>
                                            <td>{cake.image}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addCakeClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default CakeList