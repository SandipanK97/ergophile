import Home from "./pages/Home";
import Career from "./pages/Career";
import Contact from "./pages/Contact";
import Login from "./pages/Login";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/career" element={<Career />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
       </Routes>
    </BrowserRouter>
  );
}

export default App;
