import React, { useState } from 'react'
import { addEmployee } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')

    const [error, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: ''
    })

    function validateForm() {
        let valid = true;
        const errorsCopy = {... error};

        if(firstName.trim()){
            errorsCopy.firstName = ''
        }else {
            errorsCopy.firstName = 'First name is required';
            valid = false;
        }

        if(lastName.trim()){
            errorsCopy.lastName = ''
        }else {
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }

        if(email.trim()){
            errorsCopy.email = ''
        }else {
            errorsCopy.email = 'First name is required';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    const navigator = useNavigate();
        
    function addEmployeeIn(e) {
        e.preventDefault(); 
        const employee = {firstName, lastName, email};
        console.log(employee);
        
        if(validateForm()) {
            addEmployee(employee).then((response) => {
                console.log(response.data);
                navigator('/employees'); // Assuming `navigate` is a function to navigate
            });
        }
    }
    

  return (
    <div className='container'>
        <br /> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>add Employee</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name</label>
                            <input 
                                type='text'
                                placeholder='First Name'
                                name='firstName'
                                value={firstName}
                                className={`form-control ${ error.firstName ? 'is-invalid': ''}`}
                                onChange={(e) => setFirstName(e.target.value)}
                            />
                             { error.firstName && <div className='invalid-feedback'>{ error.firstName }</div> }
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name</label>
                            <input 
                                type='text'
                                placeholder='Last Name'
                                name='lastName'
                                value={lastName}
                                className={`form-control ${ error.lastName ? 'is-invalid': ''}`}
                                onChange={(e) => setLastName(e.target.value)}
                            />
                            { error.lastName && <div className='invalid-feedback'>{ error.lastName }</div> }
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Email</label>
                            <input 
                                type='text'
                                placeholder='Email'
                                name='email'
                                value={email}
                                className={`form-control ${ error.email ? 'is-invalid': ''}`}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                             { error.email && <div className='invalid-feedback'>{ error.email }</div> }
                        </div>

                        <button className='btn btn-success' onClick={addEmployeeIn}>ADD</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent