function showPopup(event) {
    event.preventDefault(); 
    alert("BMI = kg/m2 where kg is a person's weight in kilograms and m2 is their height in metres squared."); 
}

function showPopup2(event) {
    event.preventDefault(); 
    alert("You can measure your waist circumference by wrapping a tape measure around your waist just above your hips, standing up straight, and breathing out."); 
}

function showPopupName(event) {
    event.preventDefault(); 
    alert("Enter your name"); 

}

function showPopupSurname(event) {
    event.preventDefault(); 
    alert("Enter your surname"); 
}

function showPopupAge(event) {
    event.preventDefault(); 
    alert("Enter your age"); 
}

function showPopupActive(event) {
    event.preventDefault(); 
    alert("Do you have minimum 30min physical activity daily, please answer with yes or no"); 
}

function showPopupEat(event) {
    event.preventDefault(); 
    alert("How often do you eat healthy, please answer with 1 if you eat everyday or 0 if you do not"); 
}

function showPopupHyber(event){
    event.preventDefault();
    alert("Have you taken any Antihybertensive drug before");
}

function showPopupBlood(event){
    event.preventDefault();
    alert("Have you ever had high blood glucose before, answer with year or not please");
}

function showPopupRelative(event){
    event.preventDefault();
    alert("Have any of the members of your immediate family or other relatives been dignosed with diabetes (type 1 or type 2 ) please answer 0 for no, 1 for not first degree relative and 2 for first degree relative");
}
function showPopupSex(event){
    event.preventDefault();
    alert("Enter your sex");
}

function getSequentialID() {
    let currentID = localStorage.getItem('currentID');
    if (!currentID) {
        currentID = 1;
    } else {
        currentID = parseInt(currentID, 10) + 1;
    }
    localStorage.setItem('currentID', currentID);
    return currentID;
}

let ID = getSequentialID();
const text = `Your ID is ${ID}`;
document.getElementById('id').innerHTML = text;

function returnValues(){
    const id = document.getElementById("idInput").value;
    const name = document.getElementById("name").value;
    const surname = document.getElementById("surname").value;
    const age = document.getElementById("age").value;
    const bmi = document.getElementById("bmi").value;
    const waist = document.getElementById("waist").value;
    const active = document.getElementById("active").value;
    const eat = document.getElementById("eat").value;
    const hyber = document.getElementById("hyber").value;
    const blood = document.getElementById("blood").value;
    const relative = document.getElementById("relative").value;
    const sex = document.getElementById("sex").value;

    return [id, name, surname, age, bmi, waist, active, eat, hyber, blood, relative, sex]
}



async function sendData(){
    try {

        const [id, name, surname, age, bmi, waist, active, eat, hyber, blood, relative, sex] = returnValues();
        const data = {
            id : id,
            name : name,
            surname : surname,
            age : age,
            sex : sex,
            waist : waist,
            bodyMass : bmi,
            activity : active,
            antiHybertensive : hyber,
            bloodGlucose : blood,
            relativeDiabetes : relative,
            eating : eat
        }
        const sendPostRequest = await fetch("http://localhost:8080/send/data", {
            method : "POST",
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(data)
        });


        document.getElementById("name").value = '';
        document.getElementById("surname").value = '';
        document.getElementById("age").value = '';
        document.getElementById("bmi").value = '';
        document.getElementById("waist").value = '';
        document.getElementById("active").value = '';
        document.getElementById("eat").value = '';
        document.getElementById("hyber").value = '';
        document.getElementById("blood").value = '';
        document.getElementById("relative").value = '';
        document.getElementById("sex").value = '';

        const response = await sendPostRequest.text();
        console.log(response);
    } catch (error) {
        const text = `an error occured ${error}`;
        console.log(text);
    }

}

// GET DATA 

async function getResult(){
    try {
        const id = document.getElementById("idInput").value;
        const response = await fetch(`http://localhost:8080/get/score/${id}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.text();
        return data;
        
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function display(){
    const res = await getResult();
    document.getElementById('questionFields').classList.add('hidden');
    document.getElementById('viewResults').classList.add('hidden');
    document.getElementById('submitButton').classList.add('hidden');
    document.getElementById('resS').classList.add('resSection');
    document.getElementById('id').classList.add('hidden');
    const text = `The risk of developing type 2 diabetes within 10 years is ${res}`;
    document.getElementById("res").innerHTML = text;
    if(res < 7){
        const detail = "your chances of developing diabetes are low: estimated 1 in 100 will develope disease";
        document.getElementById("resDetail").innerHTML = detail;
    }
    else if(res >= 7 && res <= 11){
        const detail = "your chances of developing diabetes are slightly elevated: estimated 1 in 25 will develope disease";
        document.getElementById("resDetail").innerHTML = detail;
    }
    else if(res >= 12 && res <= 14){
        const detail = "your chances of developing diabetes are moderate: estimated 1 in 6 will develope disease";
        document.getElementById("resDetail").innerHTML = detail;
    }
    else if(res >= 15 && res <= 20){
        const detail = "your chances of developing diabetes are high: estimated 1 in 3 will develope disease";
        document.getElementById("resDetail").innerHTML = detail;
    }
    else if(res > 20){
        const detail = "your chances of developing diabetes are very high: estimated 1 in 2 will develope disease";
        document.getElementById("resDetail").innerHTML = detail;
    }
}


