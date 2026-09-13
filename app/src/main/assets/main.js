/**
 * Quan ly trang thai va du lieu app de (null cho tang native backend map vao sau)
 */
const AppState = {
  user: {
    name: null,
    email: null,
    gender: null,
    dob: null,
    height: null,
    weight: null
  },
  today: {
    steps: null,
    calories: null,
    activeMinutes: null,
    distanceKm: null
  },
  weeklySummary: {
    chartData: null,
    status: null,
    score: null,
    totalSteps: null,
    totalCalories: null,
    totalMinutes: null,
    totalDistance: null
  },
  settings: {
    notifications: true,
    cacheSize: null,
    heightUnit: 'm',
    weightUnit: 'kg'
  }
};

/**
 * Dieu huong man hinh
 * @param {string} screenId
 */
function navigateTo(screenId) {
  const screens = document.querySelectorAll('.screen');
  screens.forEach(screen => {
    screen.classList.remove('active');
  });

  const targetScreen = document.getElementById(screenId);
  if (targetScreen) {
    targetScreen.classList.add('active');
    // Scroll ve dau trang khi chuyen man hinh
    targetScreen.scrollTop = 0;
  }
}

/**
 * an/ hien mat khau
 * @param {string} inputId
 */
function togglePassword(inputId) {
  const input = document.getElementById(inputId);
  if (input) {
    input.type = input.type === 'password' ? 'text' : 'password';
  }
}

/**
 * Chon gioi tinh trong man hinh User info
 * @param {'male'|'female'} gender
 */
function selectGender(gender) {
  AppState.user.gender = gender;
  document.getElementById('gender-male').classList.remove('selected');
  document.getElementById('gender-female').classList.remove('selected');

  if (gender === 'male') {
    document.getElementById('gender-male').classList.add('selected');
  } else {
    document.getElementById('gender-female').classList.add('selected');
  }
}

/**
 * Hàm cập nhật UI từ biến AppState (gọi sau khi nạp core backend)
 */
function renderAppData() {
  // Cập nhật Home Screen
  document.getElementById('home-username').innerText = AppState.user.name || 'name';
  document.getElementById('home-steps').innerText = AppState.today.steps ?? '--';
  document.getElementById('home-calories').innerText = AppState.today.calories ?? '--';
  document.getElementById('home-active-mins').innerText = AppState.today.activeMinutes ?? '--';
  document.getElementById('home-distance').innerText = AppState.today.distanceKm ?? '--';

  // Cập nhật Analysis Screen
  document.getElementById('analysis-status').innerText = AppState.weeklySummary.status ?? '--';
  document.getElementById('analysis-score').innerText = AppState.weeklySummary.score ?? '--/--';
  document.getElementById('summary-steps').innerText = AppState.weeklySummary.totalSteps ?? '--';
  document.getElementById('summary-calories').innerText = AppState.weeklySummary.totalCalories ?? '--';
  document.getElementById('summary-minutes').innerText = AppState.weeklySummary.totalMinutes ?? '--';
  document.getElementById('summary-distance').innerText = AppState.weeklySummary.totalDistance ?? '--';

  // Cập nhật Profile Screen
  document.getElementById('profile-name').innerText = AppState.user.name ?? '--';
  document.getElementById('profile-email').innerText = AppState.user.email ?? '--';
  document.getElementById('profile-dob').innerText = AppState.user.dob ?? '--/--/----';
  document.getElementById('profile-height').innerText = AppState.user.height ?? '--';
  document.getElementById('profile-weight').innerText = AppState.user.weight ?? '--';

  // Cập nhật Settings
  document.getElementById('setting-cache-size').innerText = AppState.settings.cacheSize ?? '--';
}

/**
 * Thao tác Xoá cache
 */
function clearCache() {
  AppState.settings.cacheSize = "0.0MB";
  renderAppData();
  alert("Đã làm sạch bộ nhớ đệm!");
}

// Khởi chạy khi tài nguyên trang đã tải xong
document.addEventListener('DOMContentLoaded', () => {
  renderAppData();
});