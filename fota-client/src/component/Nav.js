import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import ihashib from './ihashib.jpg';

function Nav() {
  
  return (
    <>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">
            <img
              alt="logo"
              src={ihashib}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{' '}
            F-OTA
          </Navbar.Brand>
        </Container>
      </Navbar>
    </>
  );
}

export default Nav;
