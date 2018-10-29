import React, {Component} from 'react';

class AddProject extends Component {
    constructor() {
        super();
        this.state={
            "id": 1,
            "projectName": "",
            "projectCode": "",
            "description": "",
            "start_date": "",
            "end_date": "",
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e){
        this.setState({[e.target.name]:e.target.value})
    }
    onSubmit(e)
    {
        e.preventDefault();
        const newProject = {
            projectName: this.state.projectName,
            projectCode: this.state.projectCode,
            description: this.state.description,
            start_date: this.state.start_date,
            end_date: this.state.end_date,
        };
        console.log(newProject);
    }

    render() {
        return (
            <div className="project">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Create / Edit Project form</h5>
                            <hr/>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input type="text" className="form-control form-control-lg "
                                           placeholder="Project Name"
                                           onChange={this.onChange}
                                           name="projectName"
                                           value={this.state.projectName}/>
                                </div>
                                <div className="form-group">
                                    <input type="text" className="form-control form-control-lg"
                                           placeholder="Unique Project Code"
                                           onChange={this.onChange}
                                           name="projectCode" value={this.state.projectCode}
                                           />
                                </div>
                                <div className="form-group">
                                    <textarea name="description" className="form-control form-control-lg"
                                              onChange={this.onChange}
                                              placeholder="Project Description" value={this.state.description}/>
                                </div>
                                <h6>Start Date</h6>
                                <div className="form-group">
                                    <input type="date" className="form-control form-control-lg"
                                           onChange={this.onChange}
                                           name="start_date" value={this.state.start_date}/>
                                </div>
                                <h6>Estimated End Date</h6>
                                <div className="form-group">
                                    <input type="date" className="form-control form-control-lg"
                                           onChange={this.onChange}
                                           name="end_date" value={this.state.end_date}/>
                                </div>

                                <input type="submit" className="btn btn-primary btn-block mt-4"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default AddProject;