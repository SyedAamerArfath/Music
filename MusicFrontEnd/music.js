


// document.addEventListener('DOMContentLoaded', function () {
//     const musicListElement = document.getElementById('musicList');
    
//     fetch('http://localhost:8080/songbyname?name=Hai dil yeh mera')
//         .then(response => response.json())
//         .then(data => {
//             console.log(data);
//             data.data.forEach(music => {
                
//                 const audioPlayer = document.getElementById('audioPlayer');
//                 console.log(audioPlayer);

//                 console.log(music.file);
//                 let a=music.file.blob();
//                var url= URL.createObjectURL(a)
//                 audioPlayer.setAttribute("src",url)
               
               
//             });
//         })
//         .catch(error => console.error('Error fetching music data:', error));

    
       

   
// });







document.addEventListener('DOMContentLoaded', function () {
    const musicListElement = document.getElementById('musicList');
    
    fetch('http://localhost:8080/songbyname?name=Hai dil yeh mera')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            data.data.forEach(music => {
                
                const audioPlayer = document.getElementById('audioPlayer');
                console.log(audioPlayer);

                console.log(music.file);

                // Fetch the audio file content
                fetch(music.file)
                    .then(response => response.blob())
                    .then(blob => {
                        // Create a Blob URL from the fetched Blob
                        var audioUrl = URL.createObjectURL(blob);
                        
                        // Set the Blob URL as the src attribute of the audio element
                        audioPlayer.setAttribute("src", audioUrl);

                        // Remember to revoke the object URL when done to avoid memory leaks
                        // URL.revokeObjectURL(audioUrl);
                    })
                    .catch(error => console.error('Error fetching audio file:', error));
            });
        })
        .catch(error => console.error('Error fetching music data:', error));
});

