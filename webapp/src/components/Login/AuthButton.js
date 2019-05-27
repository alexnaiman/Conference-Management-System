import React, { Component } from "react";
import styled from "styled-components";

const StyledButtonContainer = styled.div`
  display: flex;
  width: 100%;
  justify-content: center;
  padding: 10px;
  padding-left: 0;
  ${"" /* align-items: */}
`;
const StyledButton = styled.button`
  width: 100%;
  height: 100%;
  background: rgba(0, 122, 228, 1);
  color: #fff;
  text-transform: capitalize;
  font-size: 18px;
  padding: 7px;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
  border-radius: 3px;
  transition: all ease 0.6s;
  &:hover {
    background: rgba(0, 228, 169, 1);
  }
`;

const AuthButton = ({ onClick, children }) => (
  <StyledButtonContainer>
    <StyledButton onClick={onClick}>{children}</StyledButton>
  </StyledButtonContainer>
);

export default AuthButton;
