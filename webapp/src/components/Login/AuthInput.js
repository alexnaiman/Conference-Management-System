import React, { Component } from "react";
import styled from "styled-components";

const InputContainer = styled.div`
  display: flex;
  position: relative;
  flex-wrap: wrap;
  width: 100%;
  margin-bottom: 1rem !important;
  flex-direction: column;
  span {
    padding-right: 10px;
    font-size: 22px;
    margin-right: 7px;
    transition: all ease 0.6s;
    color: rgba(23, 31, 35, 0.87);
    color: #b9b9b9;
  }
  input {
    width: 100%;
    margin-right: 10px;
    padding: 5px;
    padding-top: 0;
    ${"" /* margin: 5px; */}
    margin-left: 0;
    border-bottom: 2px solid rgba(0, 122, 228, 1);
    transition: all ease 0.6s;
  }
  .label {
    font-size: 12px;
    padding-left: 35px;
    color: #b9b9b9;
  }

  input:focus {
    border-bottom: 2px solid rgba(0, 228, 169, 1);
  }
  input:focus ~ span {
    color: rgba(0, 228, 169, 1);
  }
  .inputWrapper {
    display: flex;
    flex-direction: row-reverse;
    justify-content: flex-end;
  }
`;

// const Row = styled.

const Input = ({ icon, label, ...rest }) => (
  <InputContainer>
    <div className="label">{label}</div>
    <div className="inputWrapper">
      <input {...rest} />
      <span>{icon}</span>
    </div>
  </InputContainer>
);

export default Input;
