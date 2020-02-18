async function getListing(){
    //performs an ajax request to the specified url to get pokemon data then pass it to displayListing()
    let url = "https://pokeapi.co/api/v2/pokemon/?limit=50&offset=50";
    try{
        let response = await fetch(url);//1. Send http request and get response
        let result = await response.json();//2. Get data from response
        displayListing(result);// 3. Do something with the data

    }catch(e){
        console.log(e);//catch and log any errors
    }

}

function displayListing(pokeList){
    //Renders a list of pokemon links to the page
    let result = document.querySelector('#listing');

    for(let record of pokeList.results){
        result.innerHTML +=
            `<a class = "collection-item" id="${record.name}" href="#" onclick="getPokemon('${record.name}')">${record.name}</a> <br/>`;
    }
}


async function getPokemon(pokemonName){
    //given a pokemon name performs an ajax requests querying the pokemon's
    // data and pass it to displayPokemon()
    let url = "https://pokeapi.co/api/v2/pokemon/"
    url += `${pokemonName}`;

    try{
        let response = await fetch(url);//1. Send http request and get response
        let pokemon = await response.json();//2. Get data from response
        displayPokemon(pokemon);

    }catch(e){
        console.log(e);//catch and log any errors
    }
}


function displayPokemon(pokemon){
    //renders details of the specified pokemon onto the page
    let name = pokemon.name;
    document.getElementById(name).href=`#${name}`;
    let result = document.querySelector('#result');

    for( let mon of pokemon.types) {
        result.innerHTML = `
        ${name}<br/>
        <img src="${pokemon.sprites.front_default}" alt="${pokemon.name}" height="300" width="300" align="middle"><br/>
        ID: ${pokemon.id}<br/>
        Type: ${mon.type.name} <br/>
        Weight: ${pokemon.weight}<br/>
        Height: ${pokemon.height}<br/> `
    }
}

