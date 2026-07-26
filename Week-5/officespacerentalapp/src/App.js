import React from "react";
import office from "./images/office.jpg";

function App() {

  const heading = "Office Space";

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: office
    },
    {
      Name: "WeWork",
      Rent: 75000,
      Address: "Bangalore",
      Image: office
    },
    {
      Name: "Regus",
      Rent: 45000,
      Address: "Hyderabad",
      Image: office
    }
  ];

  return (
    <div style={{ marginLeft: "40px" }}>

      <h1>{heading}, at Affordable Range</h1>

      {
        officeList.map((item, index) => (

          <div key={index} style={{ marginBottom: "40px" }}>

            <img
              src={item.Image}
              alt="Office Space"
              width="300"
              height="200"
            />

            <h2>Name: {item.Name}</h2>

            <h3
              style={{
                color: item.Rent <= 60000 ? "red" : "green"
              }}
            >
              Rent: Rs. {item.Rent}
            </h3>

            <h3>Address: {item.Address}</h3>

          </div>

        ))
      }

    </div>
  );
}

export default App;