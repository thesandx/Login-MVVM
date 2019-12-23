# Login-MVVM
1.Clone this repo for loginActivty along with navigation view boilerplate code.
1.In the app manifest, set the <application> element to use one of appcompat's NoActionBar themes. Using one of these themes prevents the app from using the native ActionBar class to provide the app bar. For example:
    <application
        android:theme="@style/Theme.AppCompat.Light.NoActionBar"
        />
 2.seperate toolbar layout and include in whichever layout you want
 
 3.navigation has drawerlayout in which framelayout for content and navigation for drawer
 
 # 4.add following code for adding hamburger
  //for hamburger menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //this is hamburger
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        
# and below code for navigation callback
  {
  navigationView = findViewById(R.id.navigation_view);
        //annonymus class for interface callback
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.qr_scan) {
               # for replacing fragment
                openFragment("QR Scan",new QrScanFragment());

            }
            if (id==R.id.activity2){
              #for opening new activity and adding toolbar later in its own fragment as back button
                Intent intent = new Intent(NavigationActivity.this, ActivityDemo.class);
                startActivity(intent);
            }
            item.setChecked(true);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

# 2.to change the project name
A.close android studio 

B.change the folder name from Login-MVVM to your project name

C.now open this project by browsing not by from recent

D.change the project structure to project from Android

E.go to setting.gradle and change the project name

F.in values.string change the app name string

H.In app gradle change the application Id

I.https://stackoverflow.com/questions/16804093/rename-package-in-android-studio

# do not forget to change your remote origin
git remote -v
View existing remotes
 origin  https://github.com/user/repo.git (fetch)
 origin  https://github.com/user/repo.git (push)

git remote set-url origin https://github.com/user/repo2.git
 Change the 'origin' remote's URL

git remote -v

first push on master
git push -u origin master
